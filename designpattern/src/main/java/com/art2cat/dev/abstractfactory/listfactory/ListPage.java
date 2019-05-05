package com.art2cat.dev.abstractfactory.listfactory;

import com.art2cat.dev.abstractfactory.factory.impl.AbstractPage;
import com.art2cat.dev.abstractfactory.factory.intf.IItem;

/**
 * com.art2cat.dev.abstract_factory.listfactory
 *
 * @author art2c
 * @date 5/25/2018
 */
public class ListPage extends AbstractPage {

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head><title>").append(title).append("</title></head>\n");
        builder.append("<body>\n");
        builder.append("<h1>").append(title).append("</h1>\n");
        builder.append("<ul>\n");
        for (IItem item : contents) {
            builder.append(item.makeHTML());
        }
        builder.append("</ul>\n");
        builder.append("<hr><address>").append(author).append("</address>");
        builder.append("</body></html>\n");
        return builder.toString();
    }
}
