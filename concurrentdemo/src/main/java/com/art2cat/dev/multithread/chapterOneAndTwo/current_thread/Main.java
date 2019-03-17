package com.art2cat.dev.multithread.chapterOneAndTwo.current_thread;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class Main {

    public static void main(String[] args) {

//        new Thread(new MThread(), "A").start();
        new Thread(new CountOperate(), "B").start();
    }
}
