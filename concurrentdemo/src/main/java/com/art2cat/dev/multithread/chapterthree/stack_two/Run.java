package com.art2cat.dev.multithread.chapterthree.stack_two;

/**
 * Created by Rorschach on 10/07/2017.
 */
public class Run {

    public static void main(String[] args) {
        Stack stack = new Stack();
        PushService pushService = new PushService(stack);
        PopService popService = new PopService(stack);
        Producer producer = new Producer(pushService);
        Consumer consumer = new Consumer(popService);
        Thread threadPush = new Thread(producer, "PushService");
        Thread threadPop = new Thread(consumer, "PopService");
        Thread threadPop1 = new Thread(consumer, "PopService1");
        Thread threadPop2 = new Thread(consumer, "PopService2");
        Thread threadPop3 = new Thread(consumer, "PopService3");
        Thread threadPop4 = new Thread(consumer, "PopService4");
        threadPush.start();
        threadPop.start();
        threadPop1.start();
        threadPop2.start();
        threadPop3.start();
        threadPop4.start();

    }
}
