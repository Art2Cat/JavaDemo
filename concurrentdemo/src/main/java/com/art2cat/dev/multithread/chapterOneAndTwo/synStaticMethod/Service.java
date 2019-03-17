package com.art2cat.dev.multithread.chapterOneAndTwo.synStaticMethod;

/**
 * Created by Rorschach on 7/7/2017.
 */
class Service {

    synchronized static void printA() {
        try {
            System.out.println("线程名称: " + Thread.currentThread().getName()
                + " 在 " + System.currentTimeMillis() + "进入PrintA");
            Thread.sleep(2000);
            System.out.println("线程名称: " + Thread.currentThread().getName()
                + " 在 " + System.currentTimeMillis() + "离开PrintA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized static void printB() {
        System.out.println("线程名称: " + Thread.currentThread().getName()
            + " 在 " + System.currentTimeMillis() + "进入PrintB");
        System.out.println("线程名称: " + Thread.currentThread().getName()
            + " 在 " + System.currentTimeMillis() + "离开PrintB");
    }
}
