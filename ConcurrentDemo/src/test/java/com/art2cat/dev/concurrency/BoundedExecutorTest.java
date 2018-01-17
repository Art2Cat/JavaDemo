package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.concurrency_in_practice.applying_thread_pools.BoundedExecutor;
import java.util.concurrent.Executors;
import org.junit.Test;

public class BoundedExecutorTest {

    @Test
    public void test() throws InterruptedException {
        BoundedExecutor boundedExecutor =
            new BoundedExecutor(Executors.newSingleThreadExecutor(), 1);

        boundedExecutor.submitTask(() -> {
        });

    }
}
