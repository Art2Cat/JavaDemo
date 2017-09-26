package com.art2cat.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilter {
	public static List<Apple> filterApples(List<Apple> inventory, IAppleFilter filter) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (filter.filter(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<Apple> result = new ArrayList<Apple>();
		list.forEach((apple) -> {
			if (p.test(apple)) {
				result.add((Apple) apple);
			}
		});
		return (List<T>) result;
	}


	public static List<Apple> filterApplesByColor(List<Apple> inventory,
	                                              String color) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getColour().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory,
	                                               int weight) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory,
	                                              IAppleFilter filter) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (filter.filter(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory,
	                                               IAppleFilter filter) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (filter.filter(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

}
