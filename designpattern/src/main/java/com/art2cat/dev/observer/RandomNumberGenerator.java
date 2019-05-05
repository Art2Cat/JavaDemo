package com.art2cat.dev.observer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * com.art2cat.dev.observer
 *
 * @author art2c
 * @date 6/8/2018
 */
public class RandomNumberGenerator extends AbstractNumberGenerator {

    private static final int TIMES = 20;
    private int number;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < TIMES; i++) {
            number = ThreadLocalRandom.current().nextInt(50);
            notifyObserver();
        }
    }
}
