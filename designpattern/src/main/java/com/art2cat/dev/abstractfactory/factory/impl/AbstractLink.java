package com.art2cat.dev.abstractfactory.factory.impl;

import com.art2cat.dev.abstractfactory.factory.intf.ILink;

/**
 * com.art2cat.dev.abstract_factory.factory.impl
 *
 * @author art2c
 * @date 5/25/2018
 */
public abstract class AbstractLink extends AbstractItem implements ILink {
    
    protected String url;
    
    public AbstractLink(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
