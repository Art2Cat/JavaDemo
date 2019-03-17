package com.art2cat.dev.multithread.chapterOneAndTwo.synchronizedOneThreadIn;

/**
 * Created by Rorschach on 7/7/2017.
 */
public class Run {

    public static void main(String[] args) {
        ObjectService objectService = new ObjectService();

        Thread a1 = new Thread(objectService::serviceMethod);
        a1.setName("A");
        a1.start();
        Thread a2 = new Thread(objectService::serviceMethod);
        a2.setName("B");
        a2.start();

    }
}
