package com.art2cat.dev.java8;


import java.util.Optional;
import java.util.Properties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReadPositiveIntParamTest {
    
    private static int readDurationImperative(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        return 0;
    }
    
    private static int readDurationWithOptional(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
            .flatMap(ReadPositiveIntParamTest::s2i)
            .filter(i -> i > 0).orElse(0);
    }
    
    private static Optional<Integer> s2i(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
    
    @Test
    public void testMap() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
        
        Assertions.assertEquals(5, readDurationWithOptional(props, "a"));
        Assertions.assertEquals(0, readDurationWithOptional(props, "b"));
        Assertions.assertEquals(0, readDurationWithOptional(props, "c"));
        Assertions.assertEquals(0, readDurationWithOptional(props, "d"));
    
        Assertions.assertEquals(5, readDurationImperative(props, "a"));
        Assertions.assertEquals(0, readDurationImperative(props, "b"));
        Assertions.assertEquals(0, readDurationImperative(props, "c"));
        Assertions.assertEquals(0, readDurationImperative(props, "d"));
    }
    
}
