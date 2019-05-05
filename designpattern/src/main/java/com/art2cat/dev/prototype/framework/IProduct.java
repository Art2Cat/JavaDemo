package com.art2cat.dev.prototype.framework;

/**
 * com.art2cat.dev.prototype
 *
 * @author art2c
 * @date 5/23/2018
 */
public interface IProduct extends Cloneable {

    void use(String str);

    IProduct createClone();
}
