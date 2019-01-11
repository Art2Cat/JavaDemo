package com.art2cat.dev.java8;

public class Insurance {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + this.hashCode();
    }
}
