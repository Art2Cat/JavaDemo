package com.art2cat.dev.multi_thread.chapterThree.stack_one;

/**
 * Created by Rorschach on 10/07/2017.
 */
public class Run {

    public static void main(String[] args) {
        Stack stack = new Stack();
        PushService pushService = new PushService(stack);
        PopService popService = new PopService(stack);
        Thread threadPush = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                pushService.pushService();
            }

        }, "PushService");
        Thread threadPop = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                popService.popService();
            }

        }, "PopService");
        threadPush.start();
        threadPop.start();

    }
}
