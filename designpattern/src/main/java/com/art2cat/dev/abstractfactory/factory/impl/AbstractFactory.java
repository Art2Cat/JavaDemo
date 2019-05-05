package com.art2cat.dev.abstractfactory.factory.impl;

import com.art2cat.dev.abstractfactory.factory.intf.IFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
            double version = Double.parseDouble(System.getProperty("java.specification.version"));
            if (version >= 9) {
                Constructor constructor = Class.forName(className).getConstructor();
                factory = (IFactory) constructor.newInstance();
            } else {
                factory = (IFactory) Class.forName(className).newInstance();
            }
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException |
            NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return factory;
    }
}
