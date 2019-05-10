package com.art2cat.dev.concurrency;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SemaphoreTest extends AbstractThreadPoolTest {

    @Test
    void test() {
        Semaphore semaphore = new Semaphore(5, true);
        for (int i = 0; i < 100; i++) {
            pool.submit(new Eater(i + 1, semaphore));
        }
    }

    @Override
    public void _init() {
        pool = new TraceThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void _destroy() {
        stop(60L, TimeUnit.SECONDS);
    }

    class Eater implements Runnable {

        int index;
        Semaphore semaphore;

        Eater(int index, Semaphore semaphore) {
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
                Assertions.fail(e);
            }
        }

    }
}
