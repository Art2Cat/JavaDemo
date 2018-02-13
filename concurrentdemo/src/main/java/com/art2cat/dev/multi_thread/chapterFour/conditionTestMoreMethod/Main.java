package com.art2cat.dev.multi_thread.chapterFour.conditionTestMoreMethod;


/**
 * Created by huang.yiming on 7/12/2017.
 */
public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        Thread a = new Thread(service::methodA, "A");
        Thread aa = new Thread(service::methodA, "AA");
        Thread b = new Thread(service::methodB, "B");
        Thread bb = new Thread(service::methodB, "BB");
        a.start();
        aa.start();
        b.start();
        bb.start();
    }
}
