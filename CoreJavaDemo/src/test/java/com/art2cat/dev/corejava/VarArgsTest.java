package com.art2cat.dev.corejava;

import java.util.stream.Stream;
import org.junit.Test;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 27/12/2017
 */
public class VarArgsTest {
    
    @Test
    public void test() {
        threeDots(2, 3, 4, 1);
        threeDots(false, 2, 3, 4, 1);
    }
    
    private void threeDots(Object... objects) {
        Stream.of(objects).forEach(System.out::println);
    }
    
    private void threeDots(Boolean flag, Object... objects) {
        if (flag) {
            Stream.of(objects).forEach(System.out::println);
        }
    }
}
