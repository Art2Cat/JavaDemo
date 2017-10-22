package com.art2cat.dev.multi_thread.chapterFour.useConditionWatiNotify;

/**
 * Created by huang.yiming
 * on 7/12/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Thread thread = new Thread(service::await);
        thread.start();
        Thread.sleep(3000);
        service.signal();
    }
}
