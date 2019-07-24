package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.BusStation.BusManager;
import com.art2cat.dev.concurrency.BusStation.Passenger;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class CyclicBarrierTest extends AbstractThreadPoolTest {

    @Test
    public void test() {

        CyclicBarrier barrier = new CyclicBarrier(10, new BusManager());

        for (int i = 0; i < 50; i++) {
            pool.submit(new Passenger(barrier));
        }
    }

    @Override
    public void _init() {
        pool = new TraceThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void _destroy() {
        stop(100L, TimeUnit.SECONDS);

    }
}
