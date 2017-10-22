package com.art2cat.dev.multi_thread.chapterThree.waithasParamMethod;

/**
 * Created by huang.yiming
 * on 7/10/2017.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread thread1 = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println("wait begin time=" + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait end time=" + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();

        Thread.sleep(3000);
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("notify begin time=" + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end time=" + System.currentTimeMillis());
            }
        });

        thread2.start();
    }
}
