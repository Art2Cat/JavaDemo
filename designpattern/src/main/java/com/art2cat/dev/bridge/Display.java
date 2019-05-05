package com.art2cat.dev.bridge;

import com.art2cat.dev.bridge.impl.AbstractRawDisplay;

/**
 * com.art2cat.dev.bridge.impl
 *
 * @author art2c
 * @date 5/28/2018
 */
public class Display {

    private AbstractRawDisplay display;

    public Display(AbstractRawDisplay display) {
        this.display = display;
    }

    public void open() {
        display.rawOpen();
    }

    public void print() {
        display.rawPrint();
    }

    public void close() {
        display.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
