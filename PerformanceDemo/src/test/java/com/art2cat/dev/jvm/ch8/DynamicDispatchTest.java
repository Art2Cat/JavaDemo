package com.art2cat.dev.jvm.ch8;

import org.junit.Test;

public class DynamicDispatchTest {

    @Test
    public void test() {
        DynamicDispatch.Human gentleman = new DynamicDispatch.Man();
        DynamicDispatch.Human lady = new DynamicDispatch.Woman();

        gentleman.sayHello();
        lady.sayHello();

        gentleman = new DynamicDispatch.Woman();
        gentleman.sayHello();
    }
}
