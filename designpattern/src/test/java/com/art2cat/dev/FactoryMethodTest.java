package com.art2cat.dev;

import com.art2cat.dev.factorymethod.IDCardFactory;
import com.art2cat.dev.factorymethod.IFactory;
import com.art2cat.dev.factorymethod.IProduct;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/22/2018
 */
public class FactoryMethodTest {

    @Test
    public void test() {
        IFactory factory = new IDCardFactory();
        IProduct card1 = factory.create("Test A");
        IProduct card2 = factory.create("Test B");
        IProduct card3 = factory.create("Test C");
        card1.use();
        card2.use();
        card3.use();
    }
}
