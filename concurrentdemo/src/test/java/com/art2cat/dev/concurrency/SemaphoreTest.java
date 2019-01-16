package com.art2cat.dev.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SemaphoreTest {

    @Test
    public void test() {
        Semaphore semaphore = new Semaphore(5, true);

        ExecutorService pool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 100; i++) {
            pool.submit(new Eater(i + 1, semaphore));
        }
        pool.shutdown();
        try {
            while (!pool.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                System.out.println("waiting......");
            }
        } catch (InterruptedException e) {
            Assertions.fail();
        }
    }

    class Eater implements Runnable {

        int index;
        Semaphore semaphore;

        public Eater(int index, Semaphore semaphore) {
            this.index = index;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                int waiterCount = semaphore.getQueueLength();
                System.out.println("第" + index + "个客人到达，当前等待者共有" + waiterCount + "人");
                semaphore.acquire();
                System.out.println("第" + index + "个客人开始吃饭");
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                semaphore.release();
                System.out.println("第" + index + "个客人吃完离场");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
