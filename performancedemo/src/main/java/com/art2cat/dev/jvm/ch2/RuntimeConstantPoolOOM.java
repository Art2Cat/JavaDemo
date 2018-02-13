package com.art2cat.dev.jvm.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M Java 8 JVM args: -XX:MetaspaceSize=10M
 * -XX:MaxMetaspaceSize=10m
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("Program").append("Software").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        // JDK 1.6 the result is two false
        // JDK 1.7 the result is true and false
        // JDK 1.8 the result is two true
        // that's because JDK 8 has been removed the Permanent Generation.
    }

    private static void oomGenerate() {
        // use List to keep the reference of RuntimeConstants Pool, avoid Full GC recycle.
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i).intern());
        }
        // There was no longer PermGen Space error after Java 8, it will instead by Java Heap Space error.
    }
}