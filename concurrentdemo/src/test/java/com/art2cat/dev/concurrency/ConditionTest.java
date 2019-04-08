package com.art2cat.dev.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ConditionTest {

    static ThreadPoolExecutor pool;

    @BeforeAll
    static void init() {
        pool = new TraceThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
            new SynchronousQueue<>());
    }

    @Test
    void test() {

        final String[] strings = new String[]{"A", "B", "C"};
        final var lock = new ReentrantLock();
        final var total = strings.length;
        var ref = new Object() {
            int token = 0;
        };
        final var cvs = new ConcurrentHashMap<Integer, Condition>(3);
        cvs.put(0, lock.newCondition());
        cvs.put(1, lock.newCondition());
        cvs.put(2, lock.newCondition());

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            pool.submit(() -> {
                lock.lock();
                try {
                    for (int j = 0; j < 10; j++) {
                        while (ref.token != finalI) {
                            cvs.get(finalI).await();
                        }
                        System.out.println(strings[finalI]);
                        ref.token = (ref.token + 1) % total;
                        cvs.get(ref.token).signal();
                    }
                } catch (InterruptedException e) {
                    Assertions.fail(e);
                } finally {
                    lock.unlock();
                }
            });
        }


    }

    @Test
    void testSemaphore() {
        var semaphore = new Semaphore(3);
        var workerA = new Worker(semaphore, "A");
        var workerB = new Worker(semaphore, "B");
        var workerC = new Worker(semaphore, "C");
        for (int i = 0; i < 10; i++) {
            pool.submit(workerA);
            pool.submit(workerB);
            pool.submit(workerC);
        }
    }

    class Worker implements Runnable {

        Semaphore semaphore;
        String name;

        Worker(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(name);
            } catch (InterruptedException e) {
                Assertions.fail(e);
            } finally {
                semaphore.release();
            }
        }
    }

    @AfterAll
    static void destroy() {
        pool.shutdown();
        try {
            pool.awaitTermination(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Assertions.fail(e);
        }
    }
}
