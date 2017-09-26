package com.art2cat.dev.corejava;

public class GirlFriend extends Person implements Humanity {

    public GirlFriend(String name) {
        super(name);
    }

    @Override
    public void fuck() {
        System.out.println("ah ah ah love you darling!");
    }

    @Override
    public void mate() {

    }
}
