package com.art2cat.dev.multi_thread.chapterThree.joinTest;

/**
 * Created by Rorschach on 11/07/2017.
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);
        a.start();
        Thread.sleep(1000);
        new Thread(b::bService).start();
    }
}
