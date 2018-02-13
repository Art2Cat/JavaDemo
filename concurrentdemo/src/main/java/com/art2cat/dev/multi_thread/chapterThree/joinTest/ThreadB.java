package com.art2cat.dev.multi_thread.chapterThree.joinTest;

/**
 * Created by Rorschach on 11/07/2017.
 */
class ThreadB extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("B begin time= " + System.currentTimeMillis());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B end time= " + System.currentTimeMillis());
    }

    synchronized void bService() {
        System.out.println("bService begin time= " + System.currentTimeMillis());
    }
}
