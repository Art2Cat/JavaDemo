package com.art2cat.dev.abstractfactory.factory.impl;

import com.art2cat.dev.abstractfactory.factory.intf.IItem;

/**
 * com.art2cat.dev.abstract_factory.factory.impl
 *
 * @author art2c
 * @date 5/25/2018
 */
public abstract class AbstractItem implements IItem {
    
    protected String caption;
    
    public AbstractItem(String caption) {
        this.caption = caption;
    }
    
}
