package com.art2cat.dev.java8;

import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

public class BestPriceFinderTest {

    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    @Test
    public void test() {
        execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"));
        execute("parallel", () -> bestPriceFinder.findPricesParallel("myPhone27S"));
        execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("myPhone27S"));
        bestPriceFinder.printPricesStream("myPhone27S");
    }

    private void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }

}
