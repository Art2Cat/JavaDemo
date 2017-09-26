package com.art2cat.dev.multi_thread.chapterOneAndTwo.sleep;

/**
 * Created by Rorschach
 * on 6/28/2017.
 */
public class SleepT extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run Thread Name = " +
                    currentThread().getName() + " begin "
                    + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run Thread name = " +
                    currentThread().getName() + " end. "
                    + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
