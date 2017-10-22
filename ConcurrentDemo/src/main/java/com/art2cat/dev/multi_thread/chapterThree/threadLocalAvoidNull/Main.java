package com.art2cat.dev.multi_thread.chapterThree.threadLocalAvoidNull;

/**
 * Created by Rorschach
 * on 11/07/2017.
 */
public class Main {
    private static ThreadLocalExt threadLocalExt = new ThreadLocalExt();

    public static void main(String[] args) {
        if (threadLocalExt.get() == null) {
            threadLocalExt.set("This value never set");
        }

        System.out.println(threadLocalExt.get());
        System.out.println(threadLocalExt.get());
    }
}
