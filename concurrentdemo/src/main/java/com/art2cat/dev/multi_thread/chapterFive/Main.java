package com.art2cat.dev.multi_thread.chapterFive;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huang.yiming on 7/13/2017.
 */
public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();

        Date setDate = new Date(System.currentTimeMillis() + 6000);
        System.out.println("set running time: " + setDate + " current time: " + new Date(
            System.currentTimeMillis()));
        // set Daemon Thread put parameter true

        // parameter period: 1000 millisecond, ever second perform the timeTask
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("running time: " + new Date());
            }
        }, setDate, 1000);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("running time: " + new Date());
            }
        }, 6000, 1000);

    }
}
