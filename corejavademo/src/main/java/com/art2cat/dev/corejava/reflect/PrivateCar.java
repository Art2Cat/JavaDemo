package com.art2cat.dev.corejava.reflect;

/**
 * com.art2cat.dev.corejava
 *
 * @author rorschach
 * @date 3/3/18
 */
public class PrivateCar implements IVehicle {

    private String color;

    protected void drive() {
        System.out.println("drive private car! the color is " + color);
    }

    @Override
    public void introduce() {

    }
}
