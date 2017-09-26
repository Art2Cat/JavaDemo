package com.art2cat.dev.multi_thread.chapterOneAndTwo.instance_thread_security;

/**
 * Created by Rorschach
 * on 6/28/2017.
 */
public class SameNumR implements Runnable {
    private int i = 5;

    @Override
    public void run() {
        System.out.println("i = " + (i--) + " threadName = " +
                Thread.currentThread().getName());
    }
}
