package com.art2cat.dev.multithread.chapterthree.multiProducerConsumerAllWaitFix;

import com.art2cat.dev.multithread.chapterthree.IConsumer;
import com.art2cat.dev.multithread.chapterthree.multiProducerConsumerAllWait.Product;

/**
 * Created by huang.yiming on 7/10/2017.
 */
public class ConsumerAllWaitFix implements IConsumer {

    private String lock;

    public ConsumerAllWaitFix(String lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void consume() {
        try {
            synchronized (lock) {
                while (Product.value.equals("")) {
                    System.out.println("消费者： " +
                        Thread.currentThread().getName() + "处于等待中");
                    lock.wait();
                }
                Thread.sleep(1000);
                System.out.println("消费者： " +
                    Thread.currentThread().getName() + "处于运行中");
                System.out.println("获取货物的值是: " + Product.value);
                Product.value = "";
                // change notify() to notifyAll() fix "fake dead"
                lock.notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
