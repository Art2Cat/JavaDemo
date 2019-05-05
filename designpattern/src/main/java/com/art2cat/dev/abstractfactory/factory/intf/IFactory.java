package com.art2cat.dev.abstractfactory.factory.intf;

/**
 * com.art2cat.dev.abstract_factory.factory.intf
 *
 * @author art2c
 * @date 5/25/2018
 */
public interface IFactory {

    ILink createLink(String caption, String url);

    ITray createTray(String caption);

    IPage createPage(String title, String author);
}
