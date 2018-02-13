package com.art2cat.dev.multi_thread.chapterThree.stack_three;

import com.art2cat.dev.multi_thread.chapterThree.stack_two.Stack;

/**
 * Created by Rorschach on 10/07/2017.
 */
class PushService {

    private Stack stack;

    PushService(Stack stack) {
        this.stack = stack;
    }

    void pushService() {
        stack.push();
    }
}
