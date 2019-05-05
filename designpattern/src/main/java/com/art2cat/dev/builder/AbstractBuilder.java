package com.art2cat.dev.builder;


/**
 * com.art2cat.dev
 *
 * @author art2c
 * @date 5/24/2018
 */
public abstract class AbstractBuilder {

    public abstract void makeTitle(String title);

    public abstract void makeString(String str);

    public abstract void makeItems(String[] items);

    public abstract void close();
}
