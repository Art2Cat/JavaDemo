package com.art2cat.dev.corejava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 27/12/2017
 */
public class VarArgsTest {
	
	@Test
	public void test() {
		threeDots(2, 3, 4, 1);
		threeDots(false, 2, 3, 4, 1);
	}
	
	private void threeDots(Object... objects) {
		Stream.of(quickSort(objects)).forEach(System.out::println);
	}
	
	private Object[] quickSort(Object[] objects) {
		Object[] less;
		Object[] great;
		Object pivot;
		if (objects.length < 2) {
			return objects;
		} else {
			
			Comparator<Object> comparator = Comparator.comparingInt(Object::hashCode);
			pivot = objects[0];
			less = Stream.of(objects).filter(o -> comparator.compare(pivot, o) >= 0).toArray();
			great = Stream.of(objects).filter(o -> comparator.compare(pivot, o) < 0).toArray();
			
		}
		List<Object> objectList = new ArrayList<>(Arrays.asList(less));
		objectList.add(pivot);
		objectList.addAll(Arrays.asList(great));
		return objectList.toArray();
	}
	
	private void threeDots(Boolean flag, Object... objects) {
		if (flag) { Stream.of(objects).forEach(System.out::println); }
	}
}
