package com.art2cat.dev.multithread.chapterthree.waitConditionCheck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang.yiming on 7/10/2017.
 */
public class CustomList {

    List<String> customList = new ArrayList<>();
    Object lock;

    public CustomList(Object lock) {
        this.lock = lock;
    }

    void add(String string) {
        synchronized (lock) {
            customList.add(string);
            System.out.println("add " + string);
            lock.notifyAll();
        }
    }

    void subtract() {
        try {
            synchronized (lock) {
                // check if customList.size is zero then always wait.
                while (customList.size() == 0) {
                    System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());

                    lock.wait();

                    System.out.println("wait end ThreadName=" + Thread.currentThread().getName());
                }
                customList.remove(0);
                System.out.println("list size=" + customList.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
