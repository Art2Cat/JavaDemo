package com.art2cat.dev.multi_thread.chapterFive.timeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huang.yiming
 * on 7/13/2017.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
            Date setDate = new Date(System.currentTimeMillis() + 60000);
            System.out.println("set running time: "+ setDate +" current time: " + new Date(System.currentTimeMillis()));
            // set Daemon Thread put parameter true
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("running time: " + new Date());
                }
            }, setDate);

    }
}
