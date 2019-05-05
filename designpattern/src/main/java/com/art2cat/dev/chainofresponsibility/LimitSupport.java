package com.art2cat.dev.chainofresponsibility;

/**
 * com.art2cat.dev.chainofresponsibility
 *
 * @author art2c
 * @date 6/4/2018
 */
public class LimitSupport extends AbstractSupport {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(ITrouble trouble) {
        return trouble.getNumber() < limit;
    }
}
