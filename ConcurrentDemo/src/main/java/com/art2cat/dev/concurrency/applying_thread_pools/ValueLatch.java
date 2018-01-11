package com.art2cat.dev.concurrency.applying_thread_pools;

import java.util.concurrent.CountDownLatch;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ValueLatch<T> {
    
    private final CountDownLatch done = new CountDownLatch(1);
    @GuardedBy("this")
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
