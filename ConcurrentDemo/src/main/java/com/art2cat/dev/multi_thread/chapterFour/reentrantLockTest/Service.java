package com.art2cat.dev.multi_thread.chapterFour.reentrantLockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huang.yiming
 * on 7/12/2017.
 */
class Service {
    ReentrantLock lock = new ReentrantLock();
    void testMethod() {
        // lock() get lock
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName: " + Thread.currentThread().getName() + " " + (i + 1));
        }
        // release lock
        lock.unlock();
    }
}
