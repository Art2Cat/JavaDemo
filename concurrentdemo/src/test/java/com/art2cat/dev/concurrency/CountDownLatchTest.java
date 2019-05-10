package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.Kitchen.AssistantCook;
import com.art2cat.dev.concurrency.Kitchen.ChiefCook;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountDownLatchTest extends AbstractThreadPoolTest {

    @Test
    public void test() {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ChiefCook chiefCook = new ChiefCook(countDownLatch, "Chief Cook");
        AssistantCook tomatoCook = new AssistantCook(countDownLatch, "Tomato Cook");
        AssistantCook eggCook = new AssistantCook(countDownLatch, "Egg Cook");
        AssistantCook spicesCook = new AssistantCook(countDownLatch, "Spices Cook");

        pool.submit(chiefCook);
        pool.submit(tomatoCook);
        pool.submit(eggCook);
        pool.submit(spicesCook);

        pool.shutdown();
        try {
            while (!pool.awaitTermination(1L, TimeUnit.SECONDS)) {
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void _init() {
        pool = new TraceThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(4));

    }


    @Override
    public void _destroy() {
        stop(1L, TimeUnit.SECONDS);

    }
}
