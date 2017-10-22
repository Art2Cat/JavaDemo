package com.art2cat.dev.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Rorschach
 * @date 22/10/2017
 */
public class CountingThread {

	@Test
	public void test() {

		Runnable runnable = () -> {
			String name = Thread.currentThread().getName();
			int count = 0;
			while (true) {
				System.out.println(name + ": " + count++);
			}
		};

		ExecutorService esA = Executors.newSingleThreadExecutor(new NamedThread("A"));
		ExecutorService esB = Executors.newSingleThreadExecutor(new NamedThread("B"));

		esA.submit(runnable);
		esB.submit(runnable);
	}

	class NamedThread implements ThreadFactory {
		private volatile String name;

		public NamedThread(String name) {
			this.name = name;
		}

		@Override
		public Thread newThread( Runnable r) {
			return new Thread(r, name);
		}
	}

}
