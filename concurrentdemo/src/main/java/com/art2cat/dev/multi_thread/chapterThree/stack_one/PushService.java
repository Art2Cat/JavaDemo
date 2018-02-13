package com.art2cat.dev.multi_thread.chapterThree.stack_one;

/**
 * Created by Rorschach on 10/07/2017.
 */
class PushService {

    Stack stack;

    PushService(Stack stack) {
        this.stack = stack;
    }

    void pushService() {
        stack.push();
    }
}
