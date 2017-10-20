package com.art2cat.dev.concurrency.applying_thread_pools;

import java.util.concurrent.*;


public class CustomizedThreadFactory implements ThreadFactory {
    private final String poolName;

    public CustomizedThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable) {
        return new CustomizedThread(runnable, poolName);
    }
}
