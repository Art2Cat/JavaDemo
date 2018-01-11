package com.art2cat.dev.multi_thread.chapterFive.multiTask;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huang.yiming on 7/13/2017.
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Date setDate = new Date(System.currentTimeMillis() + 10000);
        Date setDate1 = new Date(System.currentTimeMillis() + 20000);
        Date setDate2 = new Date(System.currentTimeMillis() + 25000);
        System.out.println("set running time: " + setDate + " current time: " + new Date(
            System.currentTimeMillis()));
        System.out.println("set running time: " + setDate1 + " current time: " + new Date(
            System.currentTimeMillis()));
        System.out.println("set running time: " + setDate2 + " current time: " + new Date(
            System.currentTimeMillis()));
        // set Daemon Thread put parameter true
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task one running time: " + new Date());
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, setDate);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task two running time: " + new Date());
            }
        }, setDate1);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task three running time: " + new Date());
            }
        }, setDate2);

    }
}
