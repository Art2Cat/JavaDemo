package com.art2cat.dev.multi_thread.chapterOneAndTwo.daemon_thread;

/**
 * Created by Rorschach
 * on 6/29/2017.
 */
public class RunMain {
    public static void main(String[] args) {
        try {
            MThread mThread = new MThread();
            // 将线程对象设为守护线程
            mThread.setDaemon(true);
            mThread.start();
            Thread.sleep(10000);
            System.out.println("isDaemon = " + mThread.isDaemon());
            System.out.println("我离开thread对象也不再打印了,也就是停止了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
