package com.art2cat.dev.jvm.ch8;

import org.junit.jupiter.api.Test;

public class StaticDispatchTest {

    private StaticDispatch dispatch = new StaticDispatch();

    @Test
    public void test() {
        StaticDispatch.Human man = new StaticDispatch.Man();
        StaticDispatch.Human lady = new StaticDispatch.Woman();

        dispatch.sayHello(man);
        dispatch.sayHello(lady);
    }

    @Test
    public void test1() {
        StaticDispatch.Man man = new StaticDispatch.Man();
        StaticDispatch.Woman lady = new StaticDispatch.Woman();

        dispatch.sayHello(man);
        dispatch.sayHello(lady);
    }

    @Test
    public void test2() {
        StaticDispatch.Human man = new StaticDispatch.Man();
        man = new StaticDispatch.Woman();

        if (man instanceof StaticDispatch.Man) {
            dispatch.sayHello((StaticDispatch.Man) man);
        }
        dispatch.sayHello((StaticDispatch.Woman) man);
    }
}
