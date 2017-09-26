package com.art2cat.dev.multi_thread.chapterOneAndTwo.synchronizedMethodLockObject;

/**
 * Created by Rorschach
 * on 7/6/2017.
 */
public class MyObject {
    synchronized void methodA() {
        try {
            System.out.println("begin methodA threadName="
                    + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end endTime=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void methodB() {
        try {
            System.out.println("begin methodB threadName="
                    + Thread.currentThread().getName() + " begin time=" +
                    System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
