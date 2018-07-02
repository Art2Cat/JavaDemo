package com.art2cat.dev.chainofresponsibility;

/**
 * com.art2cat.dev.chainofresponsibility
 *
 * @author art2c
 * @date 6/4/2018
 */
public class NoSupport extends AbstractSupport {
    
    public NoSupport(String name) {
        super(name);
    }
    
    @Override
    protected boolean resolve(ITrouble trouble) {
        return false;
    }
}
