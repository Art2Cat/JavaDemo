package com.art2cat.dev.abstractfactory.tablefactory;

import com.art2cat.dev.abstractfactory.factory.impl.AbstractTray;
import com.art2cat.dev.abstractfactory.factory.intf.IItem;

/**
 * com.art2cat.dev.abstract_factory.listfactory
 *
 * @author art2c
 * @date 5/25/2018
 */
public class TableTray extends AbstractTray {

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<td>\n").append("<table width=\"100%\" border=\"1\"><tr>");
        builder.append("<td bgcolor=\"#ccccccc\" align=\"center\" colspan=\"").append(trays.size())
            .append("\"><b>");
        builder.append(caption).append("</b></td>\n");
        builder.append("</tr>\n");
        builder.append("<tr>\n");
        for (IItem tray : trays) {
            builder.append(tray.makeHTML());
        }
        builder.append("</tr></table>\n");
        builder.append("</td>\n");
        return builder.toString();
    }
}
