package com.art2cat.dev.corejava;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    private static int k = 0;

    @Test
    public void test() {
        long i = ThreadLocalRandom.current().nextLong(50);
        System.out.println("fibonacci number: " + i);
        fibonacci(i);
        System.out.println("recursion called: " + k + " times");
    }

    private static synchronized long fibonacci(long m) {
        if (m <= 1) {
            k++;
            return m;
        }
        return fibonacci(m - 1) + fibonacci(m - 2);
    }

    @Test
    void test1() {

        int i = 0;
        int j = 2;
        if (++i < j) i = 0;
        System.out.println(i);
    }

}
