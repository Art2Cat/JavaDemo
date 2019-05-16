package com.art2cat.dev.concurrency;

import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractThreadPoolTest {

    ThreadPoolExecutor pool;

    public abstract void _init();

    public abstract void _destroy();

    @BeforeEach
    final void init() {
        _init();
        Objects.requireNonNull(pool, "ThreadPoolExecutor must be instanced.");
    }

    @AfterEach
    final void destroy() {
        _destroy();
    }

    final void stop(long awaitTime, TimeUnit timeUnit) {
        if (pool.isShutdown()) {
            System.out.println("pool isShutdown: " + pool.isShutdown());
            return;
        }
        pool.shutdown();
        try {
            pool.awaitTermination(awaitTime, timeUnit);
        } catch (InterruptedException e) {
            Assertions.fail(e);
        }
    }
}
