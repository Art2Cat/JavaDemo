package com.art2cat.dev.corejava;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    private static int k = 0;

    @Test
    public void test() {
        long i = ThreadLocalRandom.current().nextLong(100);
        fibonacci(i);
        System.out.println("recursion called: " + k + " times");
    }

    private static long fibonacci(long m) {
        if (m == 0 || m == 1) {
            k++;
            return m;
        } else {
            return fibonacci(m - 1) + fibonacci(m - 2);
        }
    }
}
