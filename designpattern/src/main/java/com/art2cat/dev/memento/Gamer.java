package com.art2cat.dev.memento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * com.art2cat.dev.memento
 *
 * @author art2c
 * @date 6/11/2018
 */
public class Gamer {
    
    private int money;
    private List<String> fruits = new ArrayList<>();
    private ThreadLocalRandom random = ThreadLocalRandom.current();
    private static final List<String> FRUIT_NAME = Arrays.asList("apple", "grape", "banana", "orange");
    
    public Gamer(int money) {
        this.money = money;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("money added.");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("reduce half money.");
        } else if (dice == 6) {
            String fruit = getFruit();
            System.out.println("get fruit (" + fruit + ")");
            fruits.add(fruit);
        } else {
            System.out.println("nothing happened.");
        }
    }
    
    public Memento createMemento() {
        Memento memento = new Memento(money);
        memento.getFruits().addAll(fruits);
        return memento;
    }
    
    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }
    
    @Override
    public String toString() {
        return "Gamer{" +
            "money=" + money +
            ", fruits=" + fruits +
            '}';
    }
    
    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = " delicious.";
        }
        return prefix + FRUIT_NAME.get(random.nextInt(FRUIT_NAME.size()));
    }
}
