package com.art2cat.dev.multithread.chapterthree.stack_four;

import com.art2cat.dev.multithread.chapterthree.stack_two.Stack;

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
