package com.art2cat.dev.multi_thread.chapterFour.reentrantLockTest;

/**
 * Created by huang.yiming
 * on 7/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Thread a = new Thread(service::testMethod);
        Thread a1 = new Thread(service::testMethod);
        Thread a2 = new Thread(service::testMethod);
        Thread a3 = new Thread(service::testMethod);
        Thread a4 = new Thread(service::testMethod);
        a.start();
        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
}
