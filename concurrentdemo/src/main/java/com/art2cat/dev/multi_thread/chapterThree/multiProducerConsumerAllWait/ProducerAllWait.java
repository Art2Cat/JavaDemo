package com.art2cat.dev.multi_thread.chapterThree.multiProducerConsumerAllWait;

import com.art2cat.dev.multi_thread.chapterThree.IProducer;

/**
 * Created by huang.yiming on 7/10/2017.
 */
public class ProducerAllWait implements IProducer {
    
    private String lock;
    
    public ProducerAllWait(String lock) {
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
                lock.notify();
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
