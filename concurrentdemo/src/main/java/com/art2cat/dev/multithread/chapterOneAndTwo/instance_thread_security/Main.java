package com.art2cat.dev.multithread.chapterOneAndTwo.instance_thread_security;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class Main {

    public static void main(String[] args) {
        SameNumR sameNumR = new SameNumR();
        Thread a = new Thread(sameNumR, "A");
        Thread b = new Thread(sameNumR, "B");
        Thread c = new Thread(sameNumR, "C");
        Thread d = new Thread(sameNumR, "D");
        Thread e = new Thread(sameNumR, "E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
