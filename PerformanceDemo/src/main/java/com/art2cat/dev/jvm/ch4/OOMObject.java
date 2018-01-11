package com.art2cat.dev.jvm.ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xmx100m -Xmx100m -XX:+UseSerialGC
 */
public class OOMObject {

    public static void fillHeap(int num) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new Object());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}

class Object {

    public byte[] placeholder = new byte[64 * 1024];
}
