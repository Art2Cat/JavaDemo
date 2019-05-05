package com.art2cat.dev;

import com.art2cat.dev.decorator.AbstractDisplay;
import com.art2cat.dev.decorator.FullBorder;
import com.art2cat.dev.decorator.SideBorder;
import com.art2cat.dev.decorator.StringDisplay;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/31/2018
 */
public class DecoratorTest {

    @Test
    public void test() {
        AbstractDisplay b1 = new StringDisplay("Hello, world.");
        AbstractDisplay b2 = new SideBorder(b1, '#');
        AbstractDisplay b3 = new FullBorder(b2);

        b1.show();
        b2.show();
        b3.show();
        System.out.println("");
        AbstractDisplay display =
            new SideBorder(
                new FullBorder(
                    new FullBorder(
                        new SideBorder(
                            new FullBorder(
                                new StringDisplay("Fuck world.")
                            ), '*'
                        )
                    )
                ), '/'
            );
        display.show();
    }

}
