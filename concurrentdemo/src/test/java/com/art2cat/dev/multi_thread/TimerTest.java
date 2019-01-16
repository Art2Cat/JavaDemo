package com.art2cat.dev.multi_thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.junit.jupiter.api.Test;

public class TimerTest {

    @Test
    public void basicTest() {
        Date setDate = new Date(System.currentTimeMillis() + 60000);
        System.out.println("set running time: " + setDate + " current time: " + new Date(
            System.currentTimeMillis()));
        // set Daemon Thread put parameter true
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("running time: " + new Date());
            }
        }, setDate);
    }

    @Test
    public void multiTaskTest() {
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

    @Test
    public void scheduleAtFixedRateTest() {
        Date setDate = new Date(System.currentTimeMillis() - 7000);
        Timer timer = new Timer();
        System.out.println("set running time: " + setDate + " current time: " + new Date(
            System.currentTimeMillis()));

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

    @Test
    public void scheduleAtFixedRate1Test() {
        Timer timer = new Timer();

        Date setDate = new Date(System.currentTimeMillis() + 6000);
        System.out.println("set running time: " + setDate + " current time: " + new Date(
            System.currentTimeMillis()));

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
