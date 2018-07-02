package com.art2cat.dev.chainofresponsibility;

/**
 * com.art2cat.dev.chainofresponsibility
 *
 * @author art2c
 * @date 6/4/2018
 */
public class OddSupport extends AbstractSupport {
    
    public OddSupport(String name) {
        super(name);
    }
    
    @Override
    protected boolean resolve(ITrouble trouble) {
        return trouble.getNumber() % 3 == 1;
    }
}
