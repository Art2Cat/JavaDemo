package com.art2cat.dev.multi_thread.chapterOneAndTwo.synLockLn_1;

/**
 * Created by Rorschach on 7/6/2017.
 */
class Service {

    synchronized void serviceA() {
        System.out.println("ServiceA");
        serviceB();
    }

    synchronized void serviceB() {
        System.out.println("ServiceB");
        serviceC();
    }

    synchronized void serviceC() {
        System.out.println("ServiceC");
    }
}
