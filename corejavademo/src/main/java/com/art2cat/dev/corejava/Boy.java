package com.art2cat.dev.corejava;

/**
 * Created by Rorschach on 2017/3/30.
 */
public class Boy extends Male implements Behavior {

    private static final int HEIGHT = 150;

    public Boy(String name, int age) {
        super(name, age, HEIGHT);
    }

    @Override
    public void speak(String word) {
        System.out.println(this.getName() + ":" + word);
    }
}
