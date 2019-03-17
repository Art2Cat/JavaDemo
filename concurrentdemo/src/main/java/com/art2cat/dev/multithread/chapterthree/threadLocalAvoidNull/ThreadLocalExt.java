package com.art2cat.dev.multithread.chapterthree.threadLocalAvoidNull;

/**
 * Created by Rorschach on 11/07/2017.
 */
class ThreadLocalExt extends ThreadLocal {

    @Override
    protected Object initialValue() {
        return "the default value, when first time get value won't be null";
    }
}
