package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.concurrency_in_practice.testing_concurrent_programs.BarrierTimer;
import com.art2cat.dev.concurrency.concurrency_in_practice.testing_concurrent_programs.SemaphoreBoundedBuffer;
import java.util.concurrent.CyclicBarrier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing with a barrier-based timer
 *
 * @author Rorschach
 * @date 22/10/2017
 */
public class TimedPutTakeTest extends PutTakeTest {

    private BarrierTimer timer = new BarrierTimer();

    TimedPutTakeTest() {
    }


    static TimedPutTakeTest build(int cap, int pairs, int trials) {
        TimedPutTakeTest takeTest = new TimedPutTakeTest();
        takeTest.bb = new SemaphoreBoundedBuffer<Integer>(cap);
        takeTest.nPairs = pairs;
        takeTest.nTrials = trials;
        takeTest.barrier = new CyclicBarrier(takeTest.nPairs * 2 + 1, takeTest.timer);
        return takeTest;
    }

    @Test
    void test2() throws Exception {
        int tpt = 100000; // trials per thread
        for (int cap = 1; cap <= 1000; cap *= 10) {
            System.out.println("Capacity: " + cap);
            for (int pairs = 1; pairs <= 128; pairs *= 2) {
                TimedPutTakeTest t = TimedPutTakeTest.build(cap, pairs, tpt);
                System.out.print("Pairs: " + pairs + "\t");
                t.start();
                System.out.print("\t");
                Thread.sleep(1000);
                t.start();
                System.out.println();
                Thread.sleep(1000);
            }
        }
        pool.shutdown();
    }

    @Override
    public void start() {
        try {
            timer.clear();
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new PutTakeTest.Producer());
                pool.execute(new PutTakeTest.Consumer());
            }
            barrier.await();
            barrier.await();
            long nsPerItem = timer.getTime() / (nPairs * (long) nTrials);
            System.out.print("Throughput: " + nsPerItem + " ns/item");
            Assertions.assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
