package com.art2cat.dev.multi_thread.chapterOneAndTwo.is_alive;

import com.art2cat.dev.multi_thread.chapterOneAndTwo.current_thread.MThread;

/**
 * Created by Rorschach
 * on 6/28/2017.
 */
public class Main {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        System.out.println("begin == " + mThread.isAlive());

        mThread.start();
        Thread t1 = new IACountOperate();
        System.out.println("main begin t1 is Alive " + t1.isAlive());
        t1.setName("A");
        new Thread(t1).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end == " + mThread.isAlive());

        System.out.println("main end t1 is Alive " + t1.isAlive());
    }
}
