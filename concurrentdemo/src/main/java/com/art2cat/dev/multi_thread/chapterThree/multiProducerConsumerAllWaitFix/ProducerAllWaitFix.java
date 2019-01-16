package com.art2cat.dev.multi_thread.chapterThree.multiProducerConsumerAllWaitFix;

import com.art2cat.dev.multi_thread.chapterThree.IProducer;
import com.art2cat.dev.multi_thread.chapterThree.multiProducerConsumerAllWait.Product;

/**
 * Created by huang.yiming on 7/10/2017.
 */
public class ProducerAllWaitFix implements IProducer {

    private String lock;

    public ProducerAllWaitFix(String lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void produce() {
        try {
            System.out.println(Thread.currentThread().getName() + "running");
            synchronized (lock) {
                while (Product.value.equals("")) {
                    System.out.println("生产者： " +
                        Thread.currentThread().getName() + "处于等待中");
                    lock.wait();
                }
                Thread.sleep(1500);
                System.out.println("消费者： " +
                    Thread.currentThread().getName() + "处于运行中");
                String value = System.currentTimeMillis() + "_"
                    + System.nanoTime();
                System.out.println("生产货物的值是: " + value);
                Product.value = value;
                // change notify() to notifyAll() fix "fake dead"
                lock.notifyAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
