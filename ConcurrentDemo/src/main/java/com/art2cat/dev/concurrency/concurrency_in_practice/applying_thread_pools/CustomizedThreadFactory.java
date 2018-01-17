package com.art2cat.dev.concurrency.concurrency_in_practice.applying_thread_pools;

import java.util.concurrent.ThreadFactory;


public class CustomizedThreadFactory implements ThreadFactory {
    
    private final String poolName;
    
    public CustomizedThreadFactory(String poolName) {
        this.poolName = poolName;
    }
    
    @Override
    public Thread newThread(Runnable runnable) {
        return new CustomizedThread(runnable, poolName);
    }
}
