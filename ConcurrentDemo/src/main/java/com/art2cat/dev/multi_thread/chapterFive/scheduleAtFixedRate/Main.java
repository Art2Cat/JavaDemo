package com.art2cat.dev.multi_thread.chapterFive.scheduleAtFixedRate;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huang.yiming
 * on 7/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        Date setDate = new Date(System.currentTimeMillis() - 7000);
        Timer timer = new Timer();
        System.out.println("set running time: " + setDate + " current time: " + new Date(System.currentTimeMillis()));

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("1 begin running, time: " + new Date());
//                System.out.println("1 stop running, time: " + new Date());
//            }
//        }, setDate, 5000);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2 begin running, time: " + new Date());
                System.out.println("2 stop running, time: " + new Date());
            }
        }, setDate, 5000);
    }
}
