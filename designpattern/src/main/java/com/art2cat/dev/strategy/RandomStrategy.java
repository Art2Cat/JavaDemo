package com.art2cat.dev.strategy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * com.art2cat.dev.strategy
 *
 * @author art2c
 * @date 5/29/2018
 */
public class RandomStrategy implements IStrategy {

    public RandomStrategy() {
    }

    @Override
    public HandSign nextHandSign() {
        return HandSign.getHandSignByFlag(ThreadLocalRandom.current().nextInt(3));
    }

    @Override
    public void study(boolean win) {

    }
}
