package com.art2cat.dev.prototype.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * com.art2cat.dev.prototype
 *
 * @author art2c
 * @date 5/23/2018
 */
public class Manager {

    private Map<String, IProduct> showcase = new HashMap<>();

    public void register(String name, IProduct product) {
        showcase.put(name, product);
    }

    public IProduct create(String name) {
        IProduct p = showcase.get(name);
        return p.createClone();
    }
}
