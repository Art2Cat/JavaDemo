package com.art2cat.dev.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author rorschach.h
 */
public class Kitchen {

    static class AssistantCook implements Runnable {

        private CountDownLatch countDownLatch;
        private String name;

        public AssistantCook(CountDownLatch countDownLatch, String name) {
            this.countDownLatch = countDownLatch;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                System.out.println(name + " done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }


    }

    static class ChiefCook implements Runnable {

        private CountDownLatch countDownLatch;
        private String name;

        public ChiefCook(CountDownLatch countDownLatch, String name) {
            this.countDownLatch = countDownLatch;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " waiting……");
                countDownLatch.await();
                System.out.println(name + " start cooking");
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                System.out.println(name + " done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
