package com.art2cat.dev;

import org.junit.Test;

import java.util.concurrent.Future;

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
        long retrivalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrivalTime + " msecs");
    }
}