package com.art2cat.dev;

import com.art2cat.dev.prototype.MessageBox;
import com.art2cat.dev.prototype.UnderlinePen;
import com.art2cat.dev.prototype.framework.IProduct;
import com.art2cat.dev.prototype.framework.Manager;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/23/2018
 */
public class PrototypeTest {

    @Test
    public void test() {
        Manager manager = new Manager();
        IProduct uPen = new UnderlinePen('~');
        IProduct mBox = new MessageBox('*');
        IProduct sBox = new MessageBox('/');
        manager.register("strong message", uPen);
        manager.register("warning box", mBox);
        manager.register("slash box", sBox);

        IProduct p1 = manager.create("strong message");
        p1.use("Hello, world.");
        IProduct p2 = manager.create("warning box");
        p2.use("Hello, world.");
        IProduct p3 = manager.create("slash box");
        p3.use("Hello, world.");

    }
}
