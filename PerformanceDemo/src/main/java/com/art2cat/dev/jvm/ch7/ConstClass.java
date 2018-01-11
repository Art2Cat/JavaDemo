package com.art2cat.dev.jvm.ch7;

public class ConstClass {

    public static final String HELLOWORLD = "hell world";

    static {
        System.out.println("SubClass init!!!");
    }
}
