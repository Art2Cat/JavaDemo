package com.art2cat.dev.abstractfactory.factory.impl;

import com.art2cat.dev.abstractfactory.factory.intf.IFactory;

/**
 * com.art2cat.dev.abstract_factory
 *
 * @author art2c
 * @date 5/25/2018
 */
public abstract class AbstractFactory implements IFactory {
    
    public static IFactory getFactory(String className) {
        IFactory factory = null;
        try {
            factory = (IFactory) Class.forName(className).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return factory;
    }
}
