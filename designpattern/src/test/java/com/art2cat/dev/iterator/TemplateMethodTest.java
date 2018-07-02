package com.art2cat.dev.iterator;

import com.art2cat.dev.templatemethod.AbstractDisplay;
import com.art2cat.dev.templatemethod.CharDisplay;
import com.art2cat.dev.templatemethod.StringDisplay;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/21/2018
 */
public class TemplateMethodTest {
    
    @Test
    public void test() {
        AbstractDisplay charDisplay = new CharDisplay('H');
        AbstractDisplay stringDisplay = new StringDisplay("Hello World");
        charDisplay.display();
        stringDisplay.display();
    }
    
}
