package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.concurrency_in_practice.testing_concurrent_programs.SemaphoreBoundedBuffer;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Producer-consumer test program for BoundedBuffer
 *
 * @author Rorschach
 * @date 22/10/2017
 */
public class PutTakeTest {

    final ExecutorService pool = Executors.newCachedThreadPool();
    int nTrials, nPairs;
    final AtomicInteger putSum = new AtomicInteger(0);
    final AtomicInteger takeSum = new AtomicInteger(0);
    SemaphoreBoundedBuffer<Integer> bb;
    CyclicBarrier barrier;

    PutTakeTest() {

    }

    static PutTakeTest getInstance(int capacity, int npairs, int ntrials) {
        PutTakeTest putTakeTest = new PutTakeTest();
        putTakeTest.bb = new SemaphoreBoundedBuffer<Integer>(capacity);
        putTakeTest.nTrials = ntrials;
        putTakeTest.nPairs = npairs;
        putTakeTest.barrier = new CyclicBarrier(npairs * 2 + 1);
        return putTakeTest;
    }

    private int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

    @Test
    public void test() {
        PutTakeTest putTakeTest = PutTakeTest.getInstance(10, 10, 10000);
        putTakeTest.start();
    }

    void start() {
        try {
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await(); // wait for all threads to be ready
            barrier.await(); // wait for all threads to finish
            Assertions.assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            Assertions.fail(e);
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
