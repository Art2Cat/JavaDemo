package com.art2cat.dev.multithread.chapterOneAndTwo.is_alive;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class IACountOperate extends Thread {

    public IACountOperate() {

        System.out.println("CountOperate---begin");
        System.out.println("Thread Name is " + Thread.currentThread().getName());
        System.out.println("is Alive is  " + Thread.currentThread().isAlive());
        System.out.println("this.isAlive() " + this.isAlive());
        System.out.println("this Name is " + this.getName());
        System.out.println("CountOperate---end");

    }

    @Override
    public void run() {
        System.out.println("CountOperate---begin");
        System.out.println("Thread Name is " + Thread.currentThread().getName());
        System.out.println("is Alive is  " + Thread.currentThread().isAlive());
        System.out.println("this.isAlive() " + this.isAlive());
        System.out.println("this Name is " + this.getName());
        System.out.println("CountOperate---end");
    }
}
