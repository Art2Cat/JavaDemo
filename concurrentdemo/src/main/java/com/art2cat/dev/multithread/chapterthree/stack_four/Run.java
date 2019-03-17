package com.art2cat.dev.multithread.chapterthree.stack_four;

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
        Thread threadPush6 = new Thread(producer, "PushService6");
        Thread threadPush7 = new Thread(producer, "PushService7");
        Thread threadPop = new Thread(consumer, "PopService");
        Thread threadPop1 = new Thread(consumer, "PopService1");
        Thread threadPop2 = new Thread(consumer, "PopService2");
        Thread threadPop3 = new Thread(consumer, "PopService3");
        Thread threadPop4 = new Thread(consumer, "PopService4");
        Thread threadPop5 = new Thread(consumer, "PopService5");
        Thread threadPop6 = new Thread(consumer, "PopService6");
        Thread threadPop7 = new Thread(consumer, "PopService7");
        threadPush.start();
        threadPush1.start();
        threadPush2.start();
        threadPush3.start();
        threadPush4.start();
        threadPush5.start();
        threadPush6.start();
        threadPush7.start();
        threadPop.start();
        threadPop1.start();
        threadPop2.start();
        threadPop3.start();
        threadPop4.start();
        threadPop5.start();
        threadPop6.start();
        threadPop7.start();


    }
}
