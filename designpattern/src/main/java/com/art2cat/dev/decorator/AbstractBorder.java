package com.art2cat.dev.decorator;

/**
 * com.art2cat.dev.decorator
 *
 * @author art2c
 * @date 5/31/2018
 */
public abstract class AbstractBorder extends AbstractDisplay {
    
    protected AbstractDisplay display;
    
    protected AbstractBorder(AbstractDisplay display) {
        this.display = display;
    }
}
