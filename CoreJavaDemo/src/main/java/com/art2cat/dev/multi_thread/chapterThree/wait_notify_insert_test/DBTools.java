package com.art2cat.dev.multi_thread.chapterThree.wait_notify_insert_test;

/**
 * Created by Rorschach
 * on 10/07/2017.
 */
class DBTools {
    // multi-thread communicate flag use volatile
    volatile private boolean preIsA = false;

    synchronized void backupA() {
        try {
            while (preIsA) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " ★★★★★");
            }
            preIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void backupB() {
        try {
            while (!preIsA) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " ☆☆☆☆☆");
            }
            preIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
