package com.art2cat.dev.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		while (!executorService.isTerminated()) {
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
		while (!executorService.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
