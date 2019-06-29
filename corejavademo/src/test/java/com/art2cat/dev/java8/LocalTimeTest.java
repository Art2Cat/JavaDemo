package com.art2cat.dev.java8;


import java.time.LocalTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalTimeTest {

    @Test
    public void testParse() {
        var time = LocalTime.parse("09:30");
        var origin = LocalTime.of(9, 30);
        Assertions.assertEquals(origin, time);
        System.out.println(time);
    }
}
