package com.art2cat.dev.multi_thread.chapterThree.waitReleaseLock;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huang.yiming
 * on 7/10/2017.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Service service = new Service();
        Thread thread = new Thread(() -> {
            service.testMethod(lock);
        }, "waitThread1");
        Thread thread1 = new Thread(() -> {
            service.testMethod(lock);
        }, "waitThread2");

        thread.start();
        thread1.start();

        Timer timer = new Timer("notifyThreadTimer");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                service.notifyTest(lock);
            }
        }, 2500);

    }


}
