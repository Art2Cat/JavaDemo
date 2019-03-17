package com.art2cat.dev.multithread.chapterthree.threadLocalTest;

/**
 * Created by Rorschach on 11/07/2017.
 */
class Tools {

    // ThreadLocal give ever thread separate memory space to store they own variable
    static ThreadLocal threadLocal = new ThreadLocal();
}
