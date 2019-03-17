package com.art2cat.dev.multithread.chapterOneAndTwo.setNewStringTwoLock;

/**
 * Created by Rorschach on 7/7/2017.
 */
public class Run {

    public static void main(String[] args) {
        Service service = new Service();
        Thread a = new Thread(service::testMethod);
        a.setName("A");
        Thread b = new Thread(service::testMethod);
        b.setName("B");
        a.start();
        b.start();
    }
}
