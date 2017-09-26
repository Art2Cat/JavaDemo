package com.art2cat.dev.multi_thread.chapterOneAndTwo.stop_thread.yield;

/**
 * Created by Rorschach
 * on 6/29/2017.
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1 run priority=" + this.getPriority());
    }
}
