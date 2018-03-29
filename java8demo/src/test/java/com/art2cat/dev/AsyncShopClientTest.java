package com.art2cat.dev;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Test;

public class AsyncShopClientTest {
    
    @Test
    public void test() {
        AsyncShop shop = new AsyncShop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPrice("myPhone");
        long incocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + incocationTime + " msecs");
        try {
            System.out.println("Price is " + futurePrice.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
    
    @Test
    public void test1() {
        Executor executor = Executors.newFixedThreadPool(5, Thread::new);
        
        Menu.getMenu().stream()
            .map(dish -> CompletableFuture.supplyAsync(dish::getType, executor))
            .forEach(future -> future.thenAccept(s -> {
                System.out.println(Thread.currentThread().getName() + " : " + s);
            }));
        
    }
    
}