package com.art2cat.dev.corejava;

public interface Humanity {
    void fuck();

    default void mate() {
        System.out.println("let's make love!");
    }
}
