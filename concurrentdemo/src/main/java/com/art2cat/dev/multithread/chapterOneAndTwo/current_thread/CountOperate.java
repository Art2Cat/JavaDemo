package com.art2cat.dev.multithread.chapterOneAndTwo.current_thread;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class CountOperate extends Thread {

    public CountOperate() {
        super();
        System.out.println("CountOperate---begin");
        System.out.println("Thread Name is " + Thread.currentThread().getName());
        System.out.println("this Name is " + this.getName());
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("CountOperate---begin");
        System.out.println("Thread Name is " + Thread.currentThread().getName());
        System.out.println("this Name is " + this.getName());
        System.out.println("CountOperate---end");
    }
}
