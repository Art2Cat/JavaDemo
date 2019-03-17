package com.art2cat.dev.multithread.chapterOneAndTwo.synchronized_thread_security;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");
        Thread e = new Thread(myThread, "E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

        ALogin aa = new ALogin();
        aa.start();
        BLogin bb = new BLogin();
        bb.start();

    }
}
