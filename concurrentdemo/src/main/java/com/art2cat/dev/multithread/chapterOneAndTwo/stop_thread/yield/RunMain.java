package com.art2cat.dev.multithread.chapterOneAndTwo.stop_thread.yield;

/**
 * Created by Rorschach on 6/29/2017.
 */
public class RunMain {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
