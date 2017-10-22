package com.art2cat.dev.multi_thread.chapterThree.stack_four;

/**
 * Created by Rorschach
 * on 10/07/2017.
 */
class Consumer implements Runnable {
    PopService popService;

    Consumer(PopService popService) {
        this.popService = popService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            popService.popService();
        }
    }
}
