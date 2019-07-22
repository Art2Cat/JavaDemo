package com.art2cat.dev.tuning;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FibonacciImplTest extends FibonacciImpl {

    private int nLoops;
    private volatile double l;
    private int[] input;


    @BeforeEach
    public void prepare() {
        nLoops = 100;

        input = new int[nLoops];
        Random r = new Random();
        for (int i = 0; i < nLoops; i++) {
            input[i] = r.nextInt(50);
        }
    }

    @Test
    public void test() {

        doTest(true);
        doTest(false);
    }

    private void doTest(boolean isWarmUp) {
        var then = LocalDateTime.now();
        for (int i = 0; i < nLoops; i++) {
            l = calculate(input[i]);
        }
        if (!isWarmUp) {
            var now = LocalDateTime.now();
            System.out.println(
                    "Elapsed time:" + Duration.between(then, now).getSeconds() + "seconds");
        }

    }

    @Test
    public void testCalculate() {
        System.out.println(calculate(100));
    }
}
