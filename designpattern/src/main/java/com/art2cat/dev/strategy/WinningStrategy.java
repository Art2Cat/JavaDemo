package com.art2cat.dev.strategy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * com.art2cat.dev.strategy
 *
 * @author art2c
 * @date 5/29/2018
 */
public class WinningStrategy implements IStrategy {
    
    private ThreadLocalRandom threadLocalRandom;
    private boolean won = false;
    private HandSign preHandSign;
    
    public WinningStrategy() {
        threadLocalRandom = ThreadLocalRandom.current();
    }
    
    @Override
    public HandSign nextHandSign() {
        if (!won) {
            preHandSign = HandSign.getHandSignByFlag(threadLocalRandom.nextInt(3));
        }
        return preHandSign;
    }
    
    @Override
    public void study(boolean win) {
        won = win;
    }
}
