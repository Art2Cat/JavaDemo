package com.art2cat.dev;

import com.art2cat.dev.bridge.CountDisplay;
import com.art2cat.dev.bridge.Display;
import com.art2cat.dev.bridge.RandomDisplay;
import com.art2cat.dev.bridge.impl.StringDisplayImpl;
import com.art2cat.dev.bridge.impl.TextDisplayImpl;
import java.nio.file.Paths;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/28/2018
 */
public class BridgeTest {

    @Test
    public void test() {
        Display display = new Display(new StringDisplayImpl("Hello, World"));
        Display display1 = new Display(new StringDisplayImpl("Hello, Earth"));
        CountDisplay display2 = new CountDisplay(new StringDisplayImpl("Hello, ...."));
        display.display();
        display1.display();
        display2.display();
        display2.multiDisplay(5);

        RandomDisplay random = new RandomDisplay(new StringDisplayImpl("FXXX, World"));
        random.randomDisPlay(10);

        Display display3 = new Display(
            new TextDisplayImpl(Paths.get("src", "test", "resources", "properties.txt")));
        display3.display();
    }

}
