package com.art2cat.dev.strategy;

/**
 * com.art2cat.dev.strategy
 *
 * @author art2c
 * @date 5/29/2018
 */
public interface IStrategy {

    HandSign nextHandSign();

    void study(boolean win);
}
