package com.art2cat.dev.java8;

import java.util.Optional;

public class Person {

    private Optional<Car> car;

    private boolean isMale;

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

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
