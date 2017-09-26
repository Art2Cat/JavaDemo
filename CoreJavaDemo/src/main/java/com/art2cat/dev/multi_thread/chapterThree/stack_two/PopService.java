package com.art2cat.dev.multi_thread.chapterThree.stack_two;

/**
 * Created by Rorschach
 * on 10/07/2017.
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
