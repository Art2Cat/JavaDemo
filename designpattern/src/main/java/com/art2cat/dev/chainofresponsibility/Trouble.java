package com.art2cat.dev.chainofresponsibility;

/**
 * com.art2cat.dev.chainofresponsibility
 *
 * @author art2c
 * @date 6/4/2018
 */
public class Trouble implements ITrouble {
    
    private int number;
    
    public Trouble(int number) {
        this.number = number;
    }
    
    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return "Trouble{" +
            "number=" + number +
            '}';
    }
}
