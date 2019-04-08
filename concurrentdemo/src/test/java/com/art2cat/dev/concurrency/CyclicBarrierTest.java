package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.BusStation.BusManager;
import com.art2cat.dev.concurrency.BusStation.Passenger;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CyclicBarrierTest {

    @Test
    public void test() {

        CyclicBarrier barrier = new CyclicBarrier(10, new BusManager());

        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; i++) {
            pool.submit(new Passenger(barrier));
        }
        pool.shutdown();
        try {
            while (!pool.awaitTermination(10L, TimeUnit.SECONDS)) {
                System.out.println("waiting......");
            }
        } catch (InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
    }
}
