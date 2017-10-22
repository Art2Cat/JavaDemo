package com.art2cat.dev.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicTest {
	private long x = 0;

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

		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
		Assert.assertEquals(10, atomicLong.get());
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
		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}
		System.out.println("Finished all threads");
		Assert.assertEquals(10, money.get());
	}

	private synchronized void updateBigDecimal(AtomicReference<BigDecimal> bigDecimalAtomicReference,
	                                           BigDecimal bigDecimal) {
		if (bigDecimalAtomicReference != null && bigDecimalAtomicReference.get().compareTo(bigDecimal) == -1) {
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
		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}
		System.out.println("Finished all threads");
		Assert.assertEquals(new BigDecimal(10240), money.get());
	}
}
