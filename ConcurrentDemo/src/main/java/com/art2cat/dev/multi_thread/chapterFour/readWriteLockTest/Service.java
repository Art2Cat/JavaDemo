package com.art2cat.dev.multi_thread.chapterFour.readWriteLockTest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by huang.yiming on 7/12/2017.
 */
class Service {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    void read() {
        try {
            lock.readLock().lock();
            System.out.println("attain read lock " + Thread.currentThread().getName() +
                " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    void write() {
        try {
            lock.writeLock().lock();
            System.out.println("attain read lock " + Thread.currentThread().getName() +
                " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
