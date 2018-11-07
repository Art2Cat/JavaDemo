package com.art2cat.dev.concurrency;

import static junit.framework.TestCase.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * com.art2cat.dev.concurrency
 *
 * @author art2c
 * @date 11/7/2018
 */
public class CompletableFutureTest {
    
    @Test
    public void test() throws ExecutionException, InterruptedException {
        
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new SynchronousQueue<>());
        CompletableFuture<String> completableFuture
            = CompletableFuture.supplyAsync(() -> "Hello");
        
        CompletableFuture<String> future = completableFuture
            .thenApply(s -> s + " World");
        
        assertEquals("Hello World", future.get());
        System.out.println(future.get());
        
        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
        executorService.submit(() -> {
            try {
                Thread.sleep(500);
                stringCompletableFuture.complete("Fuck");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        CompletableFuture<String> future1 =  stringCompletableFuture.thenApplyAsync(s -> s + " World");
        System.out.println(future1.get());
    }
}
