package com.art2cat.dev.jvm.ch8;

public class StaticDispatch {
	static abstract class Human {

	}

	static class Man extends Human {
	}

	static class Woman extends Human {
	}

	public void sayHello(Human human) {
		System.out.println("hello, guy!");
	}

	public void sayHello(Man man) {
		System.out.println("hello, gentleman!");
	}

	public void sayHello(Woman woman) {
		System.out.println("hello, lady!");
	}
}
