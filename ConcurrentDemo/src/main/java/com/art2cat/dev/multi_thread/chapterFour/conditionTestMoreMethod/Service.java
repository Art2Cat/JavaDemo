package com.art2cat.dev.multi_thread.chapterFour.conditionTestMoreMethod;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huang.yiming on 7/12/2017.
 */
class Service {

    Lock lock = new ReentrantLock();

    void methodA() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName: " + Thread.currentThread().getName()
                + " time: " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA end ThreadName: " + Thread.currentThread().getName()
                + " time: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void methodB() {
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName: " + Thread.currentThread().getName()
                + " time: " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end ThreadName: " + Thread.currentThread().getName()
                + " time: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
