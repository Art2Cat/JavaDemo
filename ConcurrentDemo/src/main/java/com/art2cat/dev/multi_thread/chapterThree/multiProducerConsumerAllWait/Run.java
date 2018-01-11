package com.art2cat.dev.multi_thread.chapterThree.multiProducerConsumerAllWait;

/**
 * Created by Rorschach on 10/07/2017.
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        String lock = "lock";
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        Thread[] producers = new Thread[2];
        Thread[] consumers = new Thread[2];
        for (int i = 0; i < 2; i++) {
            producers[i] = new Thread(producer::produce);
            producers[i].setName("生产者-" + i);
            consumers[i] = new Thread(consumer::consume);
            consumers[i].setName("消费者-" + i);
            producers[i].start();
            consumers[i].start();
        }
        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " " +
                thread.getState());
        }
    }
}
