package com.art2cat.dev;

import java.util.*;

public class Person {

	private Optional<Car> car;

	public Person() {
	}

	public Person(Optional<Car> car) {
		this.car = car;
	}

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}
}
