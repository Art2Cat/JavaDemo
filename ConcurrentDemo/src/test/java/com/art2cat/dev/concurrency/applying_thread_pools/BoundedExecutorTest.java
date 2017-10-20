package com.art2cat.dev.concurrency.applying_thread_pools;

import org.junit.Test;

import java.util.concurrent.Executors;

public class BoundedExecutorTest {

	@Test
	public void test() throws InterruptedException {
		BoundedExecutor boundedExecutor =
				new BoundedExecutor(Executors.newSingleThreadExecutor(), 1);

		boundedExecutor.submitTask(() -> {
		});

	}
}
