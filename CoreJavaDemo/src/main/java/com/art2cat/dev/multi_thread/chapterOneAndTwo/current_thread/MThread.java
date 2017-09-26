package com.art2cat.dev.multi_thread.chapterOneAndTwo.current_thread;

/**
 * Created by Rorschach
 * on 6/28/2017.
 */
public class MThread extends Thread {
    public MThread() {
        System.out.println("constructor print: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        super.run();
        System.out.println("method run print: " + Thread.currentThread().getName());
    }
}
