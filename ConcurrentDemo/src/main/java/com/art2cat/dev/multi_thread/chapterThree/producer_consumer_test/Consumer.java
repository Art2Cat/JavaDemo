package com.art2cat.dev.multi_thread.chapterThree.producer_consumer_test;

import com.sun.beans.decoder.ValueObject;

import java.util.List;

/**
 * Created by huang.yiming
 * on 7/10/2017.
 */
class Consumer {
    private List<String> lock;
    Consumer(List<String> lock) {
        super();
        this.lock = lock;
    }

    void getProduct() {
        try {
            synchronized (lock) {
                while (true) {
                    if (lock.size() == 0) {
                        lock.wait();
                    }
                    System.out.println("get的值是: " + lock.get(0));
                    lock.clear();
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
