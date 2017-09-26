package com.art2cat.dev.multi_thread.chapterThree.producer_consumer_test;

import com.sun.beans.decoder.ValueObject;

import java.util.List;

/**
 * Created by huang.yiming
 * on 7/10/2017.
 */
class Producer {
    private List<String> lock;

    Producer(List<String> lock) {
        super();
        this.lock = lock;
    }

    void setProduct() {
        try {
            System.out.println(Thread.currentThread().getName() + "running");
            synchronized (lock) {
                while (true) {
                    if (lock.size() != 0) {
                        lock.wait();
                    }
                    String value = System.currentTimeMillis() + "_"
                            + System.nanoTime();
                    System.out.println("set的值是: " + value);
                    lock.add(value);
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
