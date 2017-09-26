package com.art2cat.dev.multi_thread.chapterFour.mustUseMoreCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huang.yiming
 * on 7/12/2017.
 */
class Service {
    // parameter fair if true thread sequence arrange FIFO,
    Lock lock = new ReentrantLock(true);
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();

    void awaitA() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName: " + Thread.currentThread().getName()
                    + " time: " + System.currentTimeMillis());
            conditionA.await();
            System.out.println("methodA end ThreadName: " + Thread.currentThread().getName()
                    + " time: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void awaitB() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName: " + Thread.currentThread().getName()
                    + " time: " + System.currentTimeMillis());
            conditionB.await();
            System.out.println("methodA end ThreadName: " + Thread.currentThread().getName()
                    + " time: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void signalAllA() {
        try {
            lock.lock();
            System.out.println("signalAll A time: " + System.currentTimeMillis() + " ThreadName: "
                    + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    void signalAllB() {
        try {
            lock.lock();
            System.out.println("signalAll B time: " + System.currentTimeMillis() + " ThreadName: "
                    + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
