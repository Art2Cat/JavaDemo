package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.concurrency_in_practice.Sequence;
import com.art2cat.dev.concurrency.concurrency_in_practice.UnsafeSequence;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SequenceTest {

    @Test
    public void testSafe() {
        Sequence sequence = new Sequence();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 100; i++) {
            executorService.execute(() -> {
                System.out.println("safe: " + Thread.currentThread().getName() + " : "
                    + sequence.getNext());
            });
        }

        executorService.shutdown();
        try {
            while (!executorService.awaitTermination(1L, TimeUnit.SECONDS)) {
                System.out.println("waiting...");
            }
        } catch (InterruptedException e) {
            Assertions.fail(e);
        }
        System.out.println("Finished all threads");
    }

    @Test
    public void testUnsafe() {
        UnsafeSequence sequence = new UnsafeSequence();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 100; i++) {
            executorService.execute(() -> {
                System.out.println("unsafe: " + Thread.currentThread().getName() + " : "
                    + sequence.getNext());
            });
        }

        executorService.shutdown();
        try {
            while (!executorService.awaitTermination(1L, TimeUnit.SECONDS)) {
                System.out.println("waiting...");
            }
        } catch (InterruptedException e) {
            Assertions.fail(e);
        }
        System.out.println("Finished all threads");
    }
}
