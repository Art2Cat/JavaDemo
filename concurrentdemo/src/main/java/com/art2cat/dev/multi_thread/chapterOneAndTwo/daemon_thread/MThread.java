package com.art2cat.dev.multi_thread.chapterOneAndTwo.daemon_thread;

/**
 * Created by Rorschach on 6/29/2017.
 */
public class MThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
