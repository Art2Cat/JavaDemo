package com.art2cat.dev.java8;

public class AppleGreenFilter implements IAppleFilter {

    @Override
    public boolean filter(Apple apple) {
        return "Green".equals(apple.getColour());
    }
}
