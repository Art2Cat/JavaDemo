package com.art2cat.dev.concurrency;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.concurrency
 *
 * @author art2c
 * @date 11/7/2018
 */
public class CompletableFutureTest extends AbstractThreadPoolTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");

        Assertions.assertEquals("Hello World", future.get());
        System.out.println(future.get());

        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
        pool.submit(() -> {
            try {
                Thread.sleep(500);
                stringCompletableFuture.complete("Fuck");
            } catch (InterruptedException e) {
                Assertions.fail(e);
            }
        });

        CompletableFuture<String> future1 = stringCompletableFuture
                .thenApplyAsync(s -> s + " World");
        System.out.println(future1.get());
        Assertions.assertEquals("Fuck World", future1.get());
    }

    @Override
    public void _init() {
        pool = new TraceThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void _destroy() {
        stop(1L, TimeUnit.SECONDS);

    }
}
