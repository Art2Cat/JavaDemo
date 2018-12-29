package com.art2cat.dev.java8;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppleFilterTest {
    
    List<Apple> apples;
    
    @BeforeEach
    public void init() {
        apples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Apple apple = new Apple();
            if (i % 2 == 0) {
                apple.setColour("Red");
                apple.setWeight(165);
            } else {
                apple.setColour("Green");
                apple.setWeight(165);
            }
            apples.add(apple);
        }
    }
    
    @Test
    public void testAppleFilter() {
        apples.forEach(apple -> System.out.println("apples: " + apple.getColour()));
        
        List<Apple> result = AppleFilter.filterApples(apples,
            apple -> "Red".equals(apple.getColour()) && apple.getWeight() > 150);
        
        result.forEach(apple -> System.out.println("result: " + apple.getColour()));
    }
    
    @Test
    
    public void testFilter() {
        apples.forEach(apple -> System.out.println("apples: " + apple.getColour()));
        
        List<Apple> result = AppleFilter.filter(apples,
            apple -> "Red".equals(apple.getColour()) && apple.getWeight() > 150);
        
        result.forEach(apple -> System.out.println("result: " + apple.getColour()));
    }
}
