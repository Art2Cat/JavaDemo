package com.art2cat.dev.abstractfactory.tablefactory;

import com.art2cat.dev.abstractfactory.factory.impl.AbstractLink;

/**
 * com.art2cat.dev.abstract_factory.listfactory
 *
 * @author art2c
 * @date 5/25/2018
 */
public class TableLink extends AbstractLink {

    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
