package com.art2cat.dev.singleton;

/**
 * com.art2cat.dev.Singleton
 *
 * @author art2c
 * @date 5/23/2018
 */
public class Singleton {

    private static Singleton ourInstance = new Singleton();

    private Singleton() {
        System.out.println("generate a singleton.");
    }

    public static Singleton getInstance() {
        return ourInstance;
    }

    @Override
    public String toString() {
        return String.format("Singleton{%d}", hashCode());
    }
}
