package com.art2cat.dev;

import com.art2cat.dev.facade.PageMaker;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 6/5/2018
 */
public class FacadeTest {

    @Test
    public void test() {
        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
    }
}
