package com.art2cat.dev.multi_thread.chapterOneAndTwo.sleep;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class Main {
    
    public static void main(String[] args) {
        SleepR sleepR = new SleepR();
        SleepT sleepT = new SleepT();
        System.out.println("begin = " + System.currentTimeMillis());
        sleepR.run();
        sleepT.start();
        System.out.println("end = " + System.currentTimeMillis());
    }
}
