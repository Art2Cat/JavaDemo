package com.art2cat.dev.concurrency;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtomicTest {

    private long x = 0;

    private void waitToShut(ExecutorService executorService) throws InterruptedException {
        executorService.shutdown();
        while (!executorService.awaitTermination(100, TimeUnit.MICROSECONDS)) {
            System.out.println("Still waiting...");
        }
    }

    @Test
    public void testAtomicLong() {
        final AtomicLong atomicLong = new AtomicLong(0);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                atomicLong.getAndAdd(1);
                System.out.println("AtomicLong: " + atomicLong);
            });
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(() -> {
                x = x + finalI;
                System.out.println("Long: " + x);
            });
        }

        try {
            waitToShut(executor);
        } catch (InterruptedException e) {
            Assertions.fail(e.getMessage());
        }

        System.out.println("Finished all threads");
        Assertions.assertEquals(10, atomicLong.get());
    }

    @Test
    public void testAtomicReference() {
        AtomicReference<BigDecimal> money = new AtomicReference<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 10; i++) {
            int finalI = i;
            executorService.execute(() -> {
                money.getAndSet(BigDecimal.valueOf(finalI));
                System.out.println(Thread.currentThread().getName() + " : " + money.get());
            });
        }

        try {
            waitToShut(executorService);
        } catch (InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
        System.out.println("Finished all threads");
        Assertions.assertEquals(10, money.get().intValue());
    }

    private synchronized void updateBigDecimal(
        AtomicReference<BigDecimal> bigDecimalAtomicReference,
        BigDecimal bigDecimal) {
        if (bigDecimalAtomicReference != null
            && bigDecimalAtomicReference.get().compareTo(bigDecimal) < 0) {
            bigDecimalAtomicReference.getAndSet(bigDecimal);
        }
    }

    @Test
    public void testAtomicReferenceA() {
        AtomicReference<BigDecimal> money = new AtomicReference<>(new BigDecimal(0));
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 10; i++) {
            int finalI = i << 10;
            executorService.execute(() -> {
                updateBigDecimal(money, BigDecimal.valueOf(finalI));
                System.out.println(Thread.currentThread().getName() + " : " + money.get());
            });
        }

        try {
            waitToShut(executorService);
        } catch (InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
        System.out.println("Finished all threads");
        Assertions.assertEquals(new BigDecimal(10240), money.get());
    }
}
