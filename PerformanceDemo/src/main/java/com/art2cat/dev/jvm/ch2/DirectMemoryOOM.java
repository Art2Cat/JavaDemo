package com.art2cat.dev.jvm.ch2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM args: -Xmx20m -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 << 10;

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(_1MB);
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(0);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
