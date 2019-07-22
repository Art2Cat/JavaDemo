package com.art2cat.dev.tuning;

public class FibonacciImpl {

    public double calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Must be > 0");
        }
        if (n <= 1) {
            return n;
        }
        double d = calculate(n - 2) + calculate(n - 1);
        if (Double.isInfinite(d)) {
            throw new ArithmeticException("Overflow");
        }
        return d;
    }
}
