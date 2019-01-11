package com.art2cat.dev.corejava.reflect;

/**
 * com.art2cat.dev.corejava
 *
 * @author rorschach
 * @date 3/3/18
 */
public class Car implements IVehicle {

    private String brand;
    private String color = "Green";
    private int maxSpeed;

    public Car() {
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void introduce() {
        System.out
            .println(String.format("Brand: %s, Color: %s, MaxSpeed: %d.", brand, color, maxSpeed));
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
