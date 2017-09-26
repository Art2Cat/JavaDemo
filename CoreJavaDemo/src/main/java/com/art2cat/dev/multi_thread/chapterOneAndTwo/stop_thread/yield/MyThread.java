package com.art2cat.dev.multi_thread.chapterOneAndTwo.stop_thread.yield;

/**
 * Created by Rorschach
 * on 6/29/2017.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            // yield() 放弃当前CPU 资源,让给其他任务,时间不确定
//            Thread.yield();
            count = count + (i + 1);
        }

        System.out.println("MyThread run priority=" + this.getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.setPriority(6);
        myThread1.start();
        new MyThread1().start();

        long endTime = System.currentTimeMillis();
        System.out.println("用时: " + (endTime - beginTime) + "毫秒! ");
    }
}
