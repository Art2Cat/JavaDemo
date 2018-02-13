package com.art2cat.dev.multi_thread.chapterOneAndTwo.sleep;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class SleepR extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run Thread Name = " + currentThread().getName() + " begin");
            Thread.sleep(2000);
            System.out.println("run Thread name = " +
                currentThread().getName() + " end.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
