package com.art2cat.dev;

public class AppleGreenFilter implements IAppleFilter {

	@Override
	public boolean filter(Apple apple) {
		return "Green".equals(apple.getColour());
	}
}
