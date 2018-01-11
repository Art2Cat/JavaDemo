package com.art2cat.dev.corejava;

import org.junit.Test;

public class ReplaceAllTest {

    @Test
    public void test() {
        String str = "\bParty\b MyParty";
        System.out.println(str.replaceAll("\bParty\b", "++"));
    }
}
