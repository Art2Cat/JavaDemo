package com.art2cat.dev.bridge;

import com.art2cat.dev.bridge.impl.AbstractRawDisplay;
import java.util.concurrent.ThreadLocalRandom;

/**
 * com.art2cat.dev.bridge.impl
 *
 * @author art2c
 * @date 5/28/2018
 */
public class RandomDisplay extends Display {

    private ThreadLocalRandom random;

    public RandomDisplay(AbstractRawDisplay display) {
        super(display);
        random = ThreadLocalRandom.current();
    }

    public void randomDisPlay(int times) {
        int t = random.nextInt(times);
        open();
        for (int i = 0; i < t; i++) {
            print();
        }
        close();
    }
}
