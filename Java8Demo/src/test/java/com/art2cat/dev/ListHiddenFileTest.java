package com.art2cat.dev;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class ListHiddenFileTest {
	@Test
	public void testOld() {
		ListHiddenFile listHiddenFile = new ListHiddenFile();
		Arrays.asList(listHiddenFile.listHiddenFileOld(new File("C://")))
				.forEach(System.out::println);
	}

	@Test
	public void testNew() {
		ListHiddenFile listHiddenFile = new ListHiddenFile();
		Arrays.asList(listHiddenFile.listHiddenFile(new File("C://")))
				.forEach(System.out::println);
	}
}
