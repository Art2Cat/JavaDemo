package com.art2cat.dev.thread;

/**
 * Created by Rorschach on 2017/3/29.
 */
public class CustomRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getId());
        for (int i = 0; i <= 30; i++) {
            System.out.println(Thread.currentThread().getName() + ": i equals " + i);
            if (i == 10) {
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " sleep 1 second");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (i == 15) {
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " sleep 1 second");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (i == 25) {
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " sleep 1 second");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
