package com.art2cat.dev.multithread.chapterthree.stack_three;

import com.art2cat.dev.multithread.chapterthree.stack_two.Stack;

/**
 * Created by Rorschach on 10/07/2017.
 */
class PopService {

    private Stack stack;

    PopService(Stack stack) {
        this.stack = stack;
    }

    void popService() {
        System.out.println("Pop: " + stack.pop());
    }
}
