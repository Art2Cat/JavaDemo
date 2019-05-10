package com.art2cat.dev.concurrency;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InheritableThreadLocalsTest extends AbstractThreadPoolTest {


    @Override
    public void _init() {
        pool = new TraceThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1));
    }

    @Test
    public void test() {

        InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("hello");
        pool.submit(() -> {
            Assertions.assertEquals("hello", threadLocal.get());
            threadLocal.set("world");
        });
        Assertions.assertEquals("hello", threadLocal.get());
    }

    @Override
    public void _destroy() {
        stop(1L, TimeUnit.SECONDS);
    }
}
