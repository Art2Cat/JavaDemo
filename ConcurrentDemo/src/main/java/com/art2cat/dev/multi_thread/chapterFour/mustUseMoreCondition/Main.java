package com.art2cat.dev.multi_thread.chapterFour.mustUseMoreCondition;

/**
 * Created by huang.yiming on 7/12/2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Thread a = new Thread(service::awaitA, "A");
        a.start();
        Thread b = new Thread(service::awaitB, "B");
        b.start();
        Thread.sleep(3000);
        service.signalAllA();
    }
}
