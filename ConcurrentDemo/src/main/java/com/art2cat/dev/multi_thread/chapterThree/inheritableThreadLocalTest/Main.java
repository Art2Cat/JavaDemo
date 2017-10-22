package com.art2cat.dev.multi_thread.chapterThree.inheritableThreadLocalTest;

/**
 * Created by Rorschach
 * on 11/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread " + Thread.currentThread().getName() + " get value: " + Tools.ext.get());

                Thread.sleep(100);
            }

            Thread.sleep(5000);
            new Thread(() -> {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Thread " + Thread.currentThread().getName() + " get value: " + Tools.ext.get());

                        Thread.sleep(100);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "A").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
