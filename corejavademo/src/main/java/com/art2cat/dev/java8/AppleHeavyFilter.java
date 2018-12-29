package com.art2cat.dev.java8;

public class AppleHeavyFilter implements IAppleFilter {

    @Override
    public boolean filter(Apple apple) {
        return apple.getWeight() > 150;
    }
}
