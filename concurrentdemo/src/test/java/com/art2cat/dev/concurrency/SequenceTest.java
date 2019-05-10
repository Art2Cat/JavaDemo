package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.concurrency_in_practice.Sequence;
import com.art2cat.dev.concurrency.concurrency_in_practice.UnsafeSequence;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SequenceTest extends AbstractThreadPoolTest {

    @Test
    public void testSafe() throws InterruptedException {
        Sequence sequence = new Sequence();
        for (int i = 0; i <= 100; i++) {
            pool.execute(() -> {
                System.out.println("safe: " + Thread.currentThread().getName() + " : "
                        + sequence.getNext());
            });
        }

        pool.shutdown();
        while (!pool.awaitTermination(1L, TimeUnit.SECONDS)) {

        }
        Assertions.assertEquals(101, sequence.getNext().intValue());

    }

    @Test
    public void testUnsafe() throws InterruptedException {
        UnsafeSequence sequence = new UnsafeSequence();
        for (int i = 0; i <= 100; i++) {
            pool.execute(() -> {
                System.out.println("unsafe: " + Thread.currentThread().getName() + " : "
                        + sequence.getNext());
            });
        }
        pool.shutdown();
        while (!pool.awaitTermination(1L, TimeUnit.SECONDS)) {

        }
        Assertions.assertNotEquals(100, sequence.getNext());
    }

    @Override
    public void _init() {
        pool = new TraceThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void _destroy() {
        stop(1L, TimeUnit.SECONDS);
    }
}
