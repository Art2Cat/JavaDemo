package com.art2cat.dev;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Stream6Test {
	private List<Dish> menu = Menu.getMenu();

	@Test
	public void test() {
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCaloriesDish = menu.stream().collect(maxBy(dishCaloriesComparator));

		System.out.println(mostCaloriesDish.get().getName());

		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);
		Assert.assertEquals(4200, totalCalories);

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

	public enum CaloricLevel {DIET, NORMAL, FAT}

	@Test
	public void testGroupBy() {
		Map<Dish.Type, List<Dish>> dishesByType =
				menu.stream().collect(groupingBy(Dish::getType));

		System.out.println(dishesByType);

		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
				groupingBy(dish -> {
					if (dish.getCalories() <= 400) return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700) return
							CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				}));

		System.out.println(dishesByCaloricLevel);
	}


}
