package com.art2cat.dev.multithread.chapterOneAndTwo.stop_thread.suspend_resume.disadvantage;

/**
 * Created by Rorschach on 6/29/2017.
 */
public class RunMain {

    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            Thread t1 = new Thread(() -> {
                object.printString();
            }, "test");
            t1.start();
            Thread.sleep(1000);
            Thread t2 = new Thread() {
                @Override
                public void run() {
                    super.run();
                    System.out.println("thread 2 start");
                    System.out.println();
                    object.printString();
                }
            };
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
