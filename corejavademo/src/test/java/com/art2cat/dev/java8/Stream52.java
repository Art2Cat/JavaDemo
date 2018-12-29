package com.art2cat.dev.java8;

import static java.util.stream.Collectors.toList;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Stream52 {
    
    private List<Dish> menu = Menu.getMenu();
    
    @Test
    public void testFlatMap() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> numbers1 = Arrays.asList(3, 4);
        
        List<int[]> pairs = numbers.stream()
                                   .flatMap(i -> numbers1.stream().map(j -> new int[]{i, j}))
                                   .collect(toList());
        System.out.println(pairs);
        pairs.forEach(i -> System.out.println(i[0] + "," + i[1]));
    }
    
    @Test
    public void testMatch() {
        
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is vegetarian friendly!!");
        }
        
        boolean all = menu.stream().allMatch(d -> d.getCalories() < 1000);
        Assertions.assertTrue(all);
        
        boolean none = menu.stream().noneMatch(d -> d.getCalories() >= 1000);
        Assertions.assertTrue(none);
        
    }
    
    
    @Test
    public void testFind() {
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        Assertions.assertTrue(dish.isPresent());
        
        dish.ifPresent(d -> System.out.println(d.getName()));
        
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> find = someNumbers.stream().map(x -> x * x)
                                            .filter(x -> x % 3 == 0)
                                            .findFirst();
        Assertions.assertEquals(new Integer(9), find.get());
        
        int product = someNumbers.stream().reduce(0, (a, b) -> a + b);
        Assertions.assertEquals(15, product);
    }
    
    @Test
    public void testReduce() {
        List<Integer> someNumbers = Arrays.asList(4, 5, 3, 9, 7);
        Optional<Integer> max = someNumbers.stream().reduce(Integer::max);
        Assertions.assertEquals(new Integer(9), max.orElse(1));
        
        Optional<Integer> min = someNumbers.stream().reduce(Integer::min);
        Assertions.assertEquals(new Integer(3), min.orElse(1));
    }
}
