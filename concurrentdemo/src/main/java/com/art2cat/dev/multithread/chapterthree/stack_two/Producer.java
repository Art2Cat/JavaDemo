package com.art2cat.dev.multithread.chapterthree.stack_two;

/**
 * Created by Rorschach on 10/07/2017.
 */
class Producer implements Runnable {

    private PushService pushService;

    Producer(PushService pushService) {
        this.pushService = pushService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            pushService.pushService();
        }

    }
}
