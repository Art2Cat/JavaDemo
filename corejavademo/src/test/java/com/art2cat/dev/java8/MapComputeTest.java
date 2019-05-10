package com.art2cat.dev.java8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapComputeTest {

    private Map<Integer, Set<Apple>> origin;

    @BeforeEach
    void before() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        origin = new HashMap<>();
        IntStream.range(0, 10).forEach(id -> {
            Set<Apple> apples = IntStream.range(0, 10).mapToObj(i -> {
                Apple apple = new Apple();
                if (i % 2 == 0) {
                    apple.setColour("Red");
                    apple.setWeight(random.nextInt(50, 165));
                } else {
                    apple.setColour("Green");
                    apple.setWeight(random.nextInt(50, 165));

                }
                return apple;
            }).collect(Collectors.toSet());
            origin.put(id, apples);
        });

    }

    @Test
    void test() {
        var result = new HashMap<Apple, Set<Integer>>();

        origin.forEach((id, value) -> {
                value.forEach(apple -> {
                    result.compute(apple, (app, set) -> {
                        if (Objects.isNull(set)) {
                            set = new HashSet<>();
                            set.add(id);
                        } else {
                            set.add(id);
                        }
                        return set;
                    });
                });
            }
        );

        result.entrySet().stream()
            .peek(e -> {
                System.out.println(e.getKey());
            })
            .forEach(e -> {
                e.getValue().forEach(System.out::print);
                System.out.println();
            });
    }

}
