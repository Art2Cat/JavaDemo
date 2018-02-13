package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.concurrency_in_practice.testing_concurrent_programs.SemaphoreBoundedBuffer;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Producer-consumer test program for BoundedBuffer
 *
 * @author Rorschach
 * @date 22/10/2017
 */
public class PutTakeTest {
    
    static final ExecutorService pool = Executors.newCachedThreadPool();
    final int nTrials, nPairs;
    final AtomicInteger putSum = new AtomicInteger(0);
    final AtomicInteger takeSum = new AtomicInteger(0);
    private final SemaphoreBoundedBuffer<Integer> bb;
    CyclicBarrier barrier;
    
    PutTakeTest(int capacity, int npairs, int ntrials) {
        this.bb = new SemaphoreBoundedBuffer<Integer>(capacity);
        this.nTrials = ntrials;
        this.nPairs = npairs;
        this.barrier = new CyclicBarrier(npairs * 2 + 1);
    }
    
    public static void main(String[] args) throws Exception {

    }
    
    private static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }
    
    @Test
    public void test() {
        
        new PutTakeTest(10, 10, 100000).test(); // sample parameters
        
        try {
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await(); // wait for all threads to be ready
            barrier.await(); // wait for all threads to finish
            Assert.assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        pool.shutdown();
    }
    
    class Producer implements Runnable {
        
        public void run() {
            try {
                int seed = (this.hashCode() ^ (int) System.nanoTime());
                int sum = 0;
                barrier.await();
                for (int i = nTrials; i > 0; --i) {
                    bb.put(seed);
                    sum += seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    class Consumer implements Runnable {
        
        public void run() {
            try {
                barrier.await();
                int sum = 0;
                for (int i = nTrials; i > 0; --i) {
                    sum += bb.take();
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
