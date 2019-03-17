package com.art2cat.dev.multithread.chapterthree.waitReleaseLock;

/**
 * Created by huang.yiming on 7/10/2017.
 */
class Service {

    void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin wait");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + " end wait");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void notifyTest(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin notify ");
                lock.notifyAll();
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " end notify");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
