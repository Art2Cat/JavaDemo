package com.art2cat.dev.concurrency.concurrency_in_practice.applying_thread_pools;

import java.util.concurrent.CountDownLatch;


public class ValueLatch<T> {
    
    private final CountDownLatch done = new CountDownLatch(1);

    private T value = null;
    
    public boolean isSet() {
        return (done.getCount() == 0);
    }
    
    public T getValue() throws InterruptedException {
        done.await();
        synchronized (this) {
            return value;
        }
    }
    
    public synchronized void setValue(T newValue) {
        if (!isSet()) {
            value = newValue;
            done.countDown();
        }
    }
}
