package com.art2cat.dev.abstractfactory.tablefactory;

import com.art2cat.dev.abstractfactory.factory.impl.AbstractFactory;
import com.art2cat.dev.abstractfactory.factory.intf.ILink;
import com.art2cat.dev.abstractfactory.factory.intf.IPage;
import com.art2cat.dev.abstractfactory.factory.intf.ITray;

/**
 * com.art2cat.dev.abstract_factory.factory
 *
 * @author art2c
 * @date 5/25/2018
 */
public class TableFactory extends AbstractFactory {

    @Override
    public ILink createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public ITray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public IPage createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
