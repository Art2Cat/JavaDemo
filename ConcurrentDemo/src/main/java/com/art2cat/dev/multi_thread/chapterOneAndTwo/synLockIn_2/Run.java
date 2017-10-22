package com.art2cat.dev.multi_thread.chapterOneAndTwo.synLockIn_2;

/**
 * Created by Rorschach
 * on 7/6/2017.
 */
public class Run {
    public static void main(String[] args) {
        Runnable r = () -> {
            Sub sub = new Sub();
            sub.operateISubMethod();
        };

        new Thread(r).start();
    }
}
