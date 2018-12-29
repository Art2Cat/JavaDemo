package com.art2cat.dev.java8;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingInt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Stream6Test {
    
    private List<Dish> menu = Menu.getMenu();
    
    @Test
    public void test() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = menu.stream().collect(maxBy(dishCaloriesComparator));
        
        System.out.println(mostCaloriesDish.get().getName());
        
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);
        Assertions.assertEquals(4200, totalCalories);
        
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        
        System.out.println(shortMenu);
    }
    
    @Test
    public void testReduce() {
        Stream<Integer> stream = Stream.of(1, 2, 8, 3, 4, 5, 6);
        List<Integer> numbers = stream.sorted(Comparator.comparingInt(Integer::intValue)).reduce(
            new ArrayList<>(),
            (List<Integer> l, Integer e) -> {
                l.add(e);
                return l;
            }, (List<Integer> l1, List<Integer> l2) -> {
                l1.addAll(l2);
                return l1;
            });
        
        System.out.println(numbers);
    }
    
    @Test
    public void testGroupBy() {
        Map<Dish.Type, List<Dish>> dishesByType =
            menu.stream().collect(groupingBy(Dish::getType));
        
        System.out.println(dishesByType);
        
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
            groupingBy(dish -> {
                if (dish.getCalories() <= 400) {
                    return CaloricLevel.DIET;
                } else if (dish.getCalories() <= 700) {
                    return
                        CaloricLevel.NORMAL;
                } else {
                    return CaloricLevel.FAT;
                }
            }));
        
        System.out.println(dishesByCaloricLevel);
        
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
            groupingBy(Dish::getType, counting()));
        
        System.out.println(typesCount);
        
        Map<Dish.Type, Dish> mostCaloricByType =
            menu.stream()
                .collect(groupingBy(Dish::getType,
                    collectingAndThen(
                        maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get)));
        
        System.out.println(mostCaloricByType);
    }
    
    @Test
    public void testPartitionBy() {
        Map<Boolean, List<Dish>> partitionedMenu =
            menu.stream().collect(partitioningBy(Dish::isVegetarian));
        
        System.out.println(partitionedMenu);
    }
    
    public enum CaloricLevel {DIET, NORMAL, FAT}
}
