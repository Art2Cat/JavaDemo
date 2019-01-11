package com.art2cat.dev.corejava;

import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 27/12/2017
 */
public class ComparatorTest {

    @Test
    public void test() {
        Comparator<Object> comparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.hashCode() - o2.hashCode();
            }
        };

        System.out.println(comparator.compare(2, 4));
        System.out.println(comparator.compare(2, 1));
        System.out.println(comparator.compare(2, 2));
        int[] f = new int[]{2, 3, 4};
        int[] g = new int[f.length];
        for (int i = 0; i < f.length; i++) {
            g[i] = f[i];
        }
        for (int i : g) {
            System.out.println(i);
        }
    }
}
