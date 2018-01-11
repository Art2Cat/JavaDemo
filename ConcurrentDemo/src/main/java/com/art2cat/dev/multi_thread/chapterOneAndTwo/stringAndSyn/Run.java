package com.art2cat.dev.multi_thread.chapterOneAndTwo.stringAndSyn;

/**
 * Created by Rorschach on 7/7/2017.
 */
public class Run {

    public static void main(String[] args) {
        Service service = new Service();
        Thread a = new Thread(() -> {
            service.testA();
        });
        a.setName("A");
        a.start();

        Thread b = new Thread(() -> {
            service.testB();
        });
        b.setName("B");
        b.start();
    }
}
