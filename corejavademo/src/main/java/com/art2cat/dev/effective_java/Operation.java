package com.art2cat.dev.effective_java;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * com.art2cat.dev.effective_java
 *
 * @author art2c
 * @date 4/26/2018
 */
public enum Operation {

    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },

    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };


    private static final Map<String, Operation> STRING_TO_ENUM = Stream.of(values())
        .collect(Collectors.toMap(Object::toString, e -> e));
    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation fromString(String symbol) {
        return STRING_TO_ENUM.get(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

}
