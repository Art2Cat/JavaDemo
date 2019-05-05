package com.art2cat.dev.bridge;

import com.art2cat.dev.bridge.impl.AbstractRawDisplay;

/**
 * com.art2cat.dev.bridge.impl
 *
 * @author art2c
 * @date 5/28/2018
 */
public class CountDisplay extends Display {

    public CountDisplay(AbstractRawDisplay display) {
        super(display);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
