package com.art2cat.dev.multi_thread.chapterFour.useConditionWatiNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huang.yiming on 7/12/2017.
 */
class Service {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    void await() {
        try {
            lock.lock();
            System.out.println("A");
            condition.await();
            System.out.println("B");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("release lock!");
        }
    }

    void signal() {
        try {
            lock.lock();
            System.out.println("signal time: " + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
