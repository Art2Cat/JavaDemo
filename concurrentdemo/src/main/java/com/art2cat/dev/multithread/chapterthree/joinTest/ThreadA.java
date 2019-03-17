package com.art2cat.dev.multithread.chapterthree.joinTest;

/**
 * Created by Rorschach on 11/07/2017.
 */
class ThreadA extends Thread {

    ThreadB threadB;

    ThreadA(ThreadB threadB) {
        this.threadB = threadB;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (threadB) {
                threadB.start();
                Thread.sleep(5000);
                // sleep() didn't release lock
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
