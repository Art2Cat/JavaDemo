package com.art2cat.dev.builder;

import com.sun.istack.internal.NotNull;

/**
 * com.art2cat.dev
 *
 * @author art2c
 * @date 5/24/2018
 */
public abstract class AbstractBuilder {
    
    public abstract void makeTitle(@NotNull String title);
    
    public abstract void makeString(@NotNull String str);
    
    public abstract void makeItems(@NotNull String[] items);
    
    public abstract void close();
}
