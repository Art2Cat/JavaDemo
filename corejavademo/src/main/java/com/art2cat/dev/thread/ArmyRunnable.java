package com.art2cat.dev.thread;

public class ArmyRunnable implements Runnable {

    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "perform [" + i + "]");
                Thread.yield();
            }

        }

        System.out.println(Thread.currentThread().getName() + " end the show");

    }

}
