package com.art2cat.dev.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConditionTest extends AbstractThreadPoolTest {

    private static final String EXPECT = "ABCABCABCABCABCABCABCABCABCABC";

    @Override
    public void _init() {
        pool = new TraceThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(3));
    }

    @Test
    void test() throws InterruptedException {

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

        var buffer = new StringBuffer();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            pool.submit(() -> {
                lock.lock();
                try {
                    for (int j = 0; j < 10; j++) {
                        while (ref.token != finalI) {
                            cvs.get(finalI).await();
                        }
                        buffer.append(strings[finalI]);
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

        pool.awaitTermination(1L, TimeUnit.SECONDS);
        Assertions.assertEquals(EXPECT, buffer.toString());
        System.out.println(buffer.toString());
    }


    @Override
    public void _destroy() {
        stop(1L, TimeUnit.SECONDS);
    }
}
