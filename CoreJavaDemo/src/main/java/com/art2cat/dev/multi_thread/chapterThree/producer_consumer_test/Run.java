package com.art2cat.dev.multi_thread.chapterThree.producer_consumer_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang.yiming
 * on 7/10/2017.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        List<String> product = new ArrayList<>();
        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);
        Thread thread = new Thread(producer::setProduct);
        Thread thread1 = new Thread(consumer::getProduct);
        thread.start();
        thread1.start();
    }
}
