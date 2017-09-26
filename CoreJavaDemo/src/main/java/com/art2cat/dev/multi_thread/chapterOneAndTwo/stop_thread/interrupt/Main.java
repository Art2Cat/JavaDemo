package com.art2cat.dev.multi_thread.chapterOneAndTwo.stop_thread.interrupt;

/**
 * Created by Rorschach
 * on 6/28/2017.
 */
public class Main {
    public static void main(String[] args) {

        try {
            CSThread csThread = new CSThread();
            Thread a = new Thread(csThread);
            Thread b = new Thread(csThread);
            Thread c = new Thread(csThread);
            a.start();
            b.start();
            c.start();

            Thread.sleep(2000);
            a.interrupt();
            b.interrupt();
            c.interrupt();
            System.out.println("is interrupted first check: " + Thread.interrupted());
            System.out.println("is interrupted second check: " + Thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
