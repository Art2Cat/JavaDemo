package com.art2cat.dev.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * com.art2cat.dev.memento
 *
 * @author art2c
 * @date 6/11/2018
 */
public class Memento {

    private int money;
    private List<String> fruits;

    public Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public List<String> getFruits() {
        return fruits;
    }

    public void setFruits(List<String> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(String fruit) {
        fruits.add(fruit);
    }
}
