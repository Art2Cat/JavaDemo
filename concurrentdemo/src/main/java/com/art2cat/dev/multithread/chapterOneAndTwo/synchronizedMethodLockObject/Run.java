package com.art2cat.dev.multithread.chapterOneAndTwo.synchronizedMethodLockObject;

/**
 * Created by Rorschach on 7/6/2017.
 */
public class Run {

    public static void main(String[] args) {
        MyObject object = new MyObject();
        Thread a = new Thread(() -> {
            object.methodA();
        }
        );
        a.setName("A");

        Thread b = new Thread(object::methodB);
        b.setName("B");

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        a.start();
        b.start();
    }
}
