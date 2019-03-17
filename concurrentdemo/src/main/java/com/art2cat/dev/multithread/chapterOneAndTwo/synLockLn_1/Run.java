package com.art2cat.dev.multithread.chapterOneAndTwo.synLockLn_1;

/**
 * Created by Rorschach on 7/6/2017.
 */
public class Run {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Service service = new Service();
            service.serviceA();
        });
        thread.start();
    }
}
