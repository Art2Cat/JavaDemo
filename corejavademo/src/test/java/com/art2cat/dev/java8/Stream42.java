package com.art2cat.dev.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class Stream42 {

    @Test
    public void test() {

        List<String> threeHighCaloriesDishName =
            Menu.getMenu()
                .stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloriesDishName);
    }

    @Test
    public void test2() {

        List<String> threeHighCaloriesDishName =
            Menu.getMenu()
                .stream()
                .filter(d -> {
                    System.out.println("filtering: " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping: " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloriesDishName);
    }

    @Test
    public void test3() {

        List<Integer> threeHighCaloriesDishName =
            Menu.getMenu()
                .stream()

                .map(d -> {
                    System.out.println("mapping: " + d.getName());
                    return d.getName();
                })
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloriesDishName);
    }

    @Test
    public void testFlapMap() {
        String[] words = {"goodbye", "world"};

        Stream<String> stringStream = Arrays.stream(words);
        List<String> results = stringStream.map(w -> w.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(Collectors.toList());
        System.out.println(results);
    }
}
