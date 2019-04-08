package com.art2cat.dev.concurrency;

import com.art2cat.dev.concurrency.Kitchen.AssistantCook;
import com.art2cat.dev.concurrency.Kitchen.ChiefCook;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class CountDownLatchTest {

    @Test
    public void test() {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ChiefCook chiefCook = new ChiefCook(countDownLatch, "Chief Cook");
        AssistantCook tomatoCook = new AssistantCook(countDownLatch, "Tomato Cook");
        AssistantCook eggCook = new AssistantCook(countDownLatch, "Egg Cook");
        AssistantCook spicesCook = new AssistantCook(countDownLatch, "Spices Cook");

        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.submit(chiefCook);
        pool.submit(tomatoCook);
        pool.submit(eggCook);
        pool.submit(spicesCook);

        pool.shutdown();

        try {

            while (!pool.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                System.out.println("waiting......");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
