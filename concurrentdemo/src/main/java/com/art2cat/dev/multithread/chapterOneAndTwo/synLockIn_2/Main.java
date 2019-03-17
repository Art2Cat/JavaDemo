package com.art2cat.dev.multithread.chapterOneAndTwo.synLockIn_2;

/**
 * Created by Rorschach on 7/6/2017.
 */
public class Main {

    int i = 10;

    synchronized void operateIMainMethod() {
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
