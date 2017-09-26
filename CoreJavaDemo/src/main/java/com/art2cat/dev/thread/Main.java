package com.art2cat.dev.thread;

/**
 * Created by Rorschach
 * on 6/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        testThread();
    }

    private static void testThread() {
        Thread one = new CustomThread("thread one");
        Thread two = new CustomThread("thread two");
        Thread three = new CustomThread("thread three");
        Thread four = new CustomThread("thread four");


        one.start();
        two.start();
        three.start();
        four.start();
    }
}
