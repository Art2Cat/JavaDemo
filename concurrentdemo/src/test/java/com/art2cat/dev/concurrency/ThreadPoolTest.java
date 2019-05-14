package com.art2cat.dev.concurrency;


import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Rorschach
 * @date 22/10/2017
 */
public class ThreadPoolTest extends AbstractThreadPoolTest {

    private final TestingThreadFactory threadFactory = new TestingThreadFactory();

    @Test
    void testPoolExpansion() throws InterruptedException {
        int MAX_SIZE = 10;

        for (int i = 0; i < 10 * MAX_SIZE; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        for (int i = 0; i < 20 && threadFactory.numCreated.get() < MAX_SIZE; i++) {
            Thread.sleep(1000);
        }
        Assertions.assertEquals(threadFactory.numCreated.get(), MAX_SIZE);
    }

    @Override
    public void _init() {
        pool = new TraceThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), threadFactory);
    }

    @Override
    public void _destroy() {
        stop(1L, TimeUnit.SECONDS);
    }
}

class TestingThreadFactory implements ThreadFactory {

    final AtomicInteger numCreated = new AtomicInteger(0);
    private final ThreadFactory factory = Executors.defaultThreadFactory();

    @Override
    public Thread newThread(Runnable r) {
        numCreated.incrementAndGet();
        return factory.newThread(r);
    }
}
