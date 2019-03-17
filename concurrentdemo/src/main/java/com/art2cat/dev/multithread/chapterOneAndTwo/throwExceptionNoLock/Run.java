package com.art2cat.dev.multithread.chapterOneAndTwo.throwExceptionNoLock;

/**
 * Created by Rorschach on 7/6/2017.
 */
public class Run {

    public static void main(String[] args) {
        try {
            Service service = new Service();
            Thread a = new Thread(service::testMethod);
            a.setName("a");
            a.start();
            Thread.sleep(500);
            Thread b = new Thread(service::testMethod);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
