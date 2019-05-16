package com.art2cat.dev.corejava;

import java.util.Objects;
import org.junit.jupiter.api.Test;

public class IntegerCompareTest {

    @Test
    void test() {
        var a = Integer.valueOf(127);
        var b = Integer.valueOf(127);


        System.out.println(a == b);

        System.out.println(Objects.equals(a, b));
        System.out.println(Integer.MAX_VALUE);
    }

}
