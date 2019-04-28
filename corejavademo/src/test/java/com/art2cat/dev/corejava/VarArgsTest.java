package com.art2cat.dev.corejava;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 27/12/2017
 */
class VarArgsTest {

    @Test
    void test() {
        threeDots(2, 3, 4, 1);
        System.out.println();
        threeDots(false, 2, 3, 4, 1);
        System.out.println();
        threeDots(true, 2, 3, 4, 1);
    }

    private void threeDots(Object... objects) {
        Stream.of(objects).forEach(System.out::println);
    }

    private void threeDots(Boolean flag, Object... objects) {
        Stream<Object> objectStream = Stream.of(objects);
        if (flag) {
            objectStream.forEach(System.out::println);
        } else {
            objectStream.filter(o -> o.getClass() == Integer.class && (Integer) o % 2 == 0)
                .forEach(System.out::println);
        }
    }
}
