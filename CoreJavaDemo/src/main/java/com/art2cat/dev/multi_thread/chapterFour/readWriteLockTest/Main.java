package com.art2cat.dev.multi_thread.chapterFour.readWriteLockTest;

/**
 * Created by huang.yiming
 * on 7/12/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        // there are not mutually exclusive between two readLocks
        Thread a = new Thread(service::read, "A");
        Thread b = new Thread(service::read, "B");
        a.start();
        b.start();
        // between two writeLocks have mutual exclusion
        Thread a1 = new Thread(service::write, "A1");
        Thread b1 = new Thread(service::write, "B1");
        a1.start();
        b1.start();

        // readLock and writeLock has mutual exclusion
        Thread a2 = new Thread(service::read, "A2");
        a2.start();
        Thread.sleep(1000);
        Thread b2 = new Thread(service::write, "B2");
        b2.start();
    }
}
