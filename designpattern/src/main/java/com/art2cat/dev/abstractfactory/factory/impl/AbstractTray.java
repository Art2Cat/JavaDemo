package com.art2cat.dev.abstractfactory.factory.impl;

import com.art2cat.dev.abstractfactory.factory.intf.IItem;
import com.art2cat.dev.abstractfactory.factory.intf.ITray;
import java.util.ArrayList;
import java.util.List;

/**
 * com.art2cat.dev.abstract_factory.factory.impl
 *
 * @author art2c
 * @date 5/25/2018
 */
public abstract class AbstractTray extends AbstractItem implements ITray {
    
    protected List<IItem> trays = new ArrayList<>();
    
    public AbstractTray(String caption) {
        super(caption);
    }
    
    @Override
    public void add(IItem item) {
        trays.add(item);
    }
}
