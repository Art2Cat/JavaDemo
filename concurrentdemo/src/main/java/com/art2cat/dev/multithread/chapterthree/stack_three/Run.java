package com.art2cat.dev.multithread.chapterthree.stack_three;

import com.art2cat.dev.multithread.chapterthree.stack_two.Stack;

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
        Thread threadPush1 = new Thread(producer, "PushService1");
        Thread threadPush2 = new Thread(producer, "PushService2");
        Thread threadPush3 = new Thread(producer, "PushService3");
        Thread threadPush4 = new Thread(producer, "PushService4");
        Thread threadPush5 = new Thread(producer, "PushService5");
        Thread threadPop = new Thread(consumer, "PopService");
        threadPush.start();
        threadPush1.start();
        threadPush2.start();
        threadPush3.start();
        threadPush4.start();
        threadPush5.start();
        threadPop.start();


    }
}
