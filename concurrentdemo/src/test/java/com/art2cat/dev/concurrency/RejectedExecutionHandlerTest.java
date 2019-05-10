package com.art2cat.dev.concurrency;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RejectedExecutionHandlerTest extends AbstractThreadPoolTest {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

    static void log(String string) {
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + "  " + string);
    }

    private void test(RejectedExecutionHandler handler) {
        pool.setRejectedExecutionHandler(handler);
        try {
            for (int i = 0; i < 10; i++) {
                final int index = i;
                pool.submit(() -> {
                    log(Thread.currentThread().getName() + " begin run task :" + index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Assertions.fail();
                    }
                    log(Thread.currentThread().getName() + " finish run  task :" + index);
                });
            }

            log("main thread before sleep!!!");
            Thread.sleep(4000);
            log("before shutdown()");
        } catch (Exception e) {
            if (!(handler instanceof AbortPolicy)) {
                Assertions.fail(e);
            }
        }
    }

    @Test
    void testDiscardPolicy() {
        test(new DiscardPolicy());
    }

    @Test
    void testDiscardOldestPolicy() {
        test(new DiscardOldestPolicy());
    }

    @Test
    void testAbortPolicy() {
        test(new AbortPolicy());
    }

    @Test
    void testCallerRunsPolicy() {
        test(new CallerRunsPolicy());
    }

    @Override
    public void _init() {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1);
        pool = new TraceThreadPoolExecutor(1, 1,
                0, TimeUnit.SECONDS, queue);

    }

    @Override
    public void _destroy() {
        log("after shutdown(),pool.isTerminated=" + pool.isTerminated());
        stop(1L, TimeUnit.SECONDS);
        log("now, pool.isTerminated=" + pool.isTerminated());
    }
}
