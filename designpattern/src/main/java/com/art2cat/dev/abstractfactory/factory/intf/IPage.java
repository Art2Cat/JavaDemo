package com.art2cat.dev.abstractfactory.factory.intf;

import java.io.IOException;

/**
 * com.art2cat.dev.abstract_factory.factory
 *
 * @author art2c
 * @date 5/25/2018
 */
public interface IPage {

    void add(IItem item);

    void output() throws IOException;

    String makeHTML();
}
