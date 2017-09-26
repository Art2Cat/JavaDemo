package com.art2cat.dev.multi_thread.chapterOneAndTwo.stop_thread.suspend_resume.disadvantage;

/**
 * Created by Rorschach
 * on 6/29/2017.
 */
public class SynchronizedObject {
    synchronized public void printString() {
        System.out.println("Begin");
        if (Thread.currentThread().getName().equals("test")) {
            System.out.println("Thread test is forever suspend");
            //deprecated
            Thread.currentThread().suspend();
        }
        System.out.println("End");
    }
}
