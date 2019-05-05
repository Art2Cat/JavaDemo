package com.art2cat.dev.strategy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * com.art2cat.dev.strategy
 *
 * @author art2c
 * @date 5/29/2018
 */
public class ProbStrategy implements IStrategy {

    private ThreadLocalRandom threadLocalRandom;
    private int prevHandSignFlag = 0;
    private int currentHandSignFlag = 0;
    private int[][] history = {
        {1, 1, 1,},
        {1, 1, 1,},
        {1, 1, 1,},
    };

    public ProbStrategy() {
        threadLocalRandom = ThreadLocalRandom.current();
    }

    private int getSum(int hv) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[hv][i];
        }
        return sum;
    }

    @Override
    public HandSign nextHandSign() {
        int bet = threadLocalRandom.nextInt(getSum(currentHandSignFlag));
        int handSignFlag;
        if (bet < history[currentHandSignFlag][0]) {
            handSignFlag = 0;
        } else if (bet < history[currentHandSignFlag][0] + history[currentHandSignFlag][1]) {
            handSignFlag = 1;
        } else {
            handSignFlag = 2;
        }
        prevHandSignFlag = currentHandSignFlag;
        currentHandSignFlag = handSignFlag;
        return HandSign.getHandSignByFlag(handSignFlag);
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[prevHandSignFlag][currentHandSignFlag]++;
        } else {
            history[prevHandSignFlag][(currentHandSignFlag + 1) % 3]++;
            history[prevHandSignFlag][(currentHandSignFlag + 2) % 3]++;

        }
    }
}
