package com.art2cat.dev.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class BusStation {

    private static int busCounter = 0;

    public static synchronized void departBus() {
        busCounter++;
    }

    private static String getTime() {
        return LocalDateTime.now().toString();
    }

    public static class Passenger implements Runnable {

        CyclicBarrier barrier;

        public Passenger(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(10000));
                String arriveTime = getTime();
                int index = barrier.await();
                System.out.println("第" + (10 - index) + "位乘客于" + arriveTime + "到达");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class BusManager implements Runnable {

        @Override
        public void run() {
            departBus();
            System.out.println("**********************");
            System.out.println("第" + busCounter + "辆大巴于" + getTime() + "发车");
            System.out.println("乘客到达时间如下：");
        }
    }
}
