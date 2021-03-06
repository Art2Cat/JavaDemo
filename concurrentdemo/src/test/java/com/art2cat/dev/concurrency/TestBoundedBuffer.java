package com.art2cat.dev.concurrency;


import com.art2cat.dev.concurrency.concurrency_in_practice.testing_concurrent_programs.SemaphoreBoundedBuffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Rorschach
 * @date 22/10/2017
 */
public class TestBoundedBuffer {

    private static final long LOCKUP_DETECT_TIMEOUT = 1000;
    private static final int CAPACITY = 10000;
    private static final int THRESHOLD = 10000;

    @Test
    public void testIsEmptyWhenConstructed() {
        SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        Assertions.assertTrue(bb.isEmpty());
        Assertions.assertFalse(bb.isFull());
    }

    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        for (int i = 0; i < 10; i++) {
            bb.put(i);
        }
        Assertions.assertTrue(bb.isFull());
        Assertions.assertFalse(bb.isEmpty());
    }


    @Test
    public void testTakeBlocksWhenEmpty() {
        final SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        Thread taker = new Thread(() -> {
            try {
                int unused = bb.take();
                // if we get here, it's an error
                Assertions.fail();
            } catch (InterruptedException success) {
                System.out.println("success");
            }
        });
        try {
            taker.start();
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            taker.interrupt();
            taker.join(LOCKUP_DETECT_TIMEOUT);
            Assertions.assertFalse(taker.isAlive());
        } catch (Exception unexpected) {
            Assertions.fail();
        }
    }

    void testLeak() throws InterruptedException {
        SemaphoreBoundedBuffer<Big> bb = new SemaphoreBoundedBuffer<Big>(CAPACITY);
        int heapSize1 = snapshotHeap();
        for (int i = 0; i < CAPACITY; i++) {
            bb.put(new Big());
        }
        for (int i = 0; i < CAPACITY; i++) {
            bb.take();
        }
        int heapSize2 = snapshotHeap();
        Assertions.assertTrue(Math.abs(heapSize1 - heapSize2) < THRESHOLD);
    }

    private int snapshotHeap() {
        /* Snapshot heap and return heap size */
        return 0;
    }

    public class Big {

        double[] data = new double[100000];
    }

}
