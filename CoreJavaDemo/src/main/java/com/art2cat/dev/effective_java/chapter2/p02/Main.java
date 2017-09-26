package com.art2cat.dev.effective_java.chapter2.p02;

/**
 * Created by Rorschach
 * on 2017/2/9.
 */
public class Main {

    public static void main(String[] args) {
        TestBuilder testBuilder = new TestBuilder.Builder(11, 33).build();
        testBuilder.print();
    }
}
