package com.art2cat.dev.abstractfactory.listfactory;

import com.art2cat.dev.abstractfactory.factory.impl.AbstractTray;
import com.art2cat.dev.abstractfactory.factory.intf.IItem;

/**
 * com.art2cat.dev.abstract_factory.listfactory
 *
 * @author art2c
 * @date 5/25/2018
 */
public class ListTray extends AbstractTray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<li>\n");
        builder.append(caption).append("\n");
        builder.append("<ul>\n");
        for (IItem tray : trays) {
            builder.append(tray.makeHTML());
        }
        builder.append("</ul>\n");
        builder.append("</li>\n");
        return builder.toString();
    }
}
