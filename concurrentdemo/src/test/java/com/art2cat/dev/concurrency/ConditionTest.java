package com.art2cat.dev.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

public class ConditionTest {

    static Lock lock = new ReentrantLock();
    static int index = 0;
    static Map<Integer, Condition> cvs = new ConcurrentHashMap<>();

    @Test
    public void test() {

        cvs.put(0, lock.newCondition());
        cvs.put(1, lock.newCondition());
        cvs.put(2, lock.newCondition());
        Thread a = newPrinter(i -> i % 3 == 0, "A");
        Thread b = newPrinter(i -> i % 3 == 1, "B");
        Thread c = newPrinter(i -> i % 3 == 2, "C");
        a.start();
        b.start();
        c.start();
    }

    private static Thread newPrinter(Predicate<Integer> predicate, String name) {
        return new Thread(() -> {
            while (index < 30) {

                try {
                    lock.lock();
                    if (predicate.test(index)) {
//                        var na = Thread.currentThread().getName();
//                        var c = cvs.get(index % 3);
//                        c.await();
                        System.out.println(Thread.currentThread().getName());
                        index++;
//                        c.signalAll();
                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }, name);
    }
}
