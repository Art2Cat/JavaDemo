package com.art2cat.dev.jvm.ch7;

import org.junit.Test;

public class ClassLoadTest {

    @Test
    public void testPassiveReferences() {
        System.out.println(SubClass.value);
    }

    @Test
    public void testPassiveReferences1() {
        SuperClass[] sca = new SuperClass[10];
    }

    @Test
    public void testPassiveReferences2() {
        System.out.println(ConstClass.HELLOWORLD);
    }


}
