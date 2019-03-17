package com.art2cat.dev.multithread.chapterOneAndTwo.synchronized_thread_security;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class MyThread extends Thread {

    private int count = 10;

    @Override
    synchronized public void run() {
        super.run();

        count--;
        System.out.println("by " + currentThread().getName()
            + " calculate, count equals " + count);

    }
}
