package com.art2cat.dev.factorymethod;

/**
 * com.art2cat.dev.factorymethod
 *
 * @author art2c
 * @date 5/22/2018
 */
public abstract class AbstractFactory {

    public final IProduct create(String owner) {
        IProduct p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract void registerProduct(IProduct p);

    protected abstract IProduct createProduct(String owner);
}
