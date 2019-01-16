package com.art2cat.dev.multi_thread.chapterOneAndTwo.stringAndSyn;

/**
 * Created by Rorschach on 7/7/2017.
 */
class Service {

    static void print(String string) {
        try {
            synchronized (string) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void testA() {
        Object ob = new Object();
        synchronized (ob) {
            System.out.println("TestA begin");
            boolean isTrue = true;
            while (isTrue) {
                //
            }
            System.out.println("TesA end");
        }
    }

    public void testB() {
        Object ob = new Object();
        synchronized (ob) {
            System.out.println("TestB begin");
            System.out.println("TestB end");
        }
    }
}
