package com.art2cat.dev.multi_thread.chapterOneAndTwo.stop_thread.suspend_resume;

/**
 * Created by Rorschach on 6/29/2017.
 */
@Deprecated
public class Main {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(5000);
            // part A
            thread.suspend();
            System.out.println("A = " + System.currentTimeMillis() + " i = "
                + thread.getId());
            Thread.sleep(5000);
            System.out.println("A = " + System.currentTimeMillis() + " i = "
                + thread.getId());
            // part B
            thread.resume();
            Thread.sleep(5000);
            // part C
            thread.suspend();
            System.out.println("B = " + System.currentTimeMillis() + " i = "
                + thread.getId());
            Thread.sleep(5000);
            System.out.println("B = " + System.currentTimeMillis() + " i = "
                + thread.getId());
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
