package com.art2cat.dev.strategy;

import java.util.stream.Stream;

/**
 * com.art2cat.dev.strategy
 *
 * @author art2c
 * @date 5/29/2018
 */
public enum HandSign {
    Rock(0), Paper(1), Scissors(2);
    
    private int flag;
    
    HandSign(int flag) {
        this.flag = flag;
    }
    
    public int getFlag() {
        return flag;
    }
    
    public static HandSign getHandSignByFlag(int flag) {
        return Stream.of(HandSign.values())
            .filter(handSign -> handSign.getFlag() == flag).findFirst().orElse(null);
    }
    
    public boolean isStrongerThan(HandSign handSign) {
        return fight(handSign) == 1;
    }
    
    public boolean isWeakerThan(HandSign handSign) {
        return fight(handSign) == -1;
    }
    
    private int fight(HandSign handSign) {
        return this.compareTo(handSign);
    }
}
