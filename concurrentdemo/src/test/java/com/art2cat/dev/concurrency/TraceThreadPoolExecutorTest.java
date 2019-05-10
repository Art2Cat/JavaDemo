package com.art2cat.dev.concurrency;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.concurrency
 *
 * @author art2c
 * @date 11/6/2018
 */
class TraceThreadPoolExecutorTest extends AbstractThreadPoolTest {

    @Test
    void test() {

        try {
            for (int i = 15; i >= 0; i--) {
                pool.execute(new DivTask(50, i));
            }
            Assertions.fail();
        } catch (Exception e) {
            System.out.println("success");
        }
    }

    @Override
    public void _init() {
        pool = new TraceThreadPoolExecutor(0, 5, 0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>());
    }

    @Override
    public void _destroy() {
        stop(1L, TimeUnit.SECONDS);
    }

    class DivTask implements Runnable {

        int a, b;

        DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double result = a / b;
            System.out.println(result);
        }
    }
}
