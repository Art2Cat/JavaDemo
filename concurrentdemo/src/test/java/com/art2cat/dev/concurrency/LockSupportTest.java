package com.art2cat.dev.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

class LockSupportTest {

    @Test
    void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            int sum = IntStream.range(0, 10).sum();
            LockSupport.park();
            System.out.println(sum);
        });
        thread.start();

        Thread.currentThread().join(1000L);

        LockSupport.unpark(thread);
    }

    static int sum = 0;

    @Test
    void test1() throws InterruptedException {
        var lock = new ReentrantLock();
        Thread thread = new Thread(() -> {

            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100L);
                    if (i == 5) {
                        Thread.yield();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + sum++);

                }

                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A");
        Thread thread1 = new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + " : " + System.currentTimeMillis());
                lock.tryLock();
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + " : " + System.currentTimeMillis());
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100L);
                    System.out.println(Thread.currentThread().getName() + " " + sum++);
                }
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread())
                    lock.unlock();
            }

        }, "B");
        Thread thread2 = new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + " : " + System.currentTimeMillis());
                lock.tryLock();
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + " : " + System.currentTimeMillis());
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100L);
                    System.out.println(Thread.currentThread().getName() + " " + sum++);
                }
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread())
                    lock.unlock();
            }

        }, "C");
        thread.start();
        thread1.start();
        thread2.start();
        System.out.println(thread.getName() + " print in main thread " + thread.getState());
        Thread.sleep(500L);
        System.out.println(thread1.getName() + " print in main thread " + thread1.getState());
        System.out.println(thread2.getName() + " print in main thread " + thread2.getState());

        Thread.currentThread().join(2500L);
        System.out.println(sum);

    }
}
