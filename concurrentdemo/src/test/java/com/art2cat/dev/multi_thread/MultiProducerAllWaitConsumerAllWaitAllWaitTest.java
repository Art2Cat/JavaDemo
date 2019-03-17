package com.art2cat.dev.multi_thread;

import com.art2cat.dev.multithread.chapterthree.IConsumer;
import com.art2cat.dev.multithread.chapterthree.IProducer;
import com.art2cat.dev.multithread.chapterthree.multiProducerConsumerAllWait.ConsumerAllWait;
import com.art2cat.dev.multithread.chapterthree.multiProducerConsumerAllWait.ProducerAllWait;
import com.art2cat.dev.multithread.chapterthree.multiProducerConsumerAllWaitFix.ConsumerAllWaitFix;
import com.art2cat.dev.multithread.chapterthree.multiProducerConsumerAllWaitFix.ProducerAllWaitFix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.multi_thread
 *
 * @author huang.yiming
 * @date 1/17/2018
 */
public class MultiProducerAllWaitConsumerAllWaitAllWaitTest {

    @Test
    public void test() {
        String lock = "lock";
        IProducer producer = new ProducerAllWait(lock);
        IConsumer consumer = new ConsumerAllWait(lock);
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " " +
                thread.getState());
        }
    }

    @Test
    public void testFix() {
        String lock = "lock";
        IProducer producer = new ProducerAllWaitFix(lock);
        IConsumer consumer = new ConsumerAllWaitFix(lock);
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " " +
                thread.getState());
        }
    }
}
