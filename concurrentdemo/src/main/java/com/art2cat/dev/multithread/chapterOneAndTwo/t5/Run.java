package com.art2cat.dev.multithread.chapterOneAndTwo.t5;

/**
 * Created by Rorschach on 7/6/2017.
 */
public class Run {

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(() -> {
            CommonUtils.beginTime1 = System.currentTimeMillis();
            task.doLongTimeTask();
            CommonUtils.endTime1 = System.currentTimeMillis();
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            CommonUtils.beginTime2 = System.currentTimeMillis();
            task.doLongTimeTask();
            CommonUtils.endTime2 = System.currentTimeMillis();
        });
        thread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }

        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 < CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }

        System.out.println("耗时: " + ((endTime - beginTime) / 1000));
    }
}
