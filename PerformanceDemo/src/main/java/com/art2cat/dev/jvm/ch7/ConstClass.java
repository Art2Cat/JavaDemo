package com.art2cat.dev.jvm.ch7;

public class ConstClass {

	static {
		System.out.println("SubClass init!!!");
	}

	public static final String HELLOWORLD = "hell world";
}
