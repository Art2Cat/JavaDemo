package com.art2cat.dev.multi_thread.chapterThree.threadLocalTest;

/**
 * Created by Rorschach
 * on 11/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Thread a = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    Tools.threadLocal.set("ThreadA " + i);
                    System.out.println("ThreadA getValue: " + Tools.threadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread b = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    Tools.threadLocal.set("ThreadB " + i);
                    System.out.println("ThreadB getValue: " + Tools.threadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            a.start();
            b.start();

            for (int i = 0; i < 100; i++) {
                Tools.threadLocal.set("Main " + i);
                System.out.println("Main getValue: " + Tools.threadLocal.get());

                Thread.sleep(200);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
