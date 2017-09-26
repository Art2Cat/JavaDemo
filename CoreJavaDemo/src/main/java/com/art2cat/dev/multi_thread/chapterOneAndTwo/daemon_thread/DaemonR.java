package com.art2cat.dev.multi_thread.chapterOneAndTwo.daemon_thread;

/**
 * Created by Rorschach
 * on 6/29/2017.
 */
public class DaemonR implements Runnable {
    @Override
    public void run() {
        while (true) {
            for (int i = 1; i <= 3 ; i++) {
                System.out.println("守护线程: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
