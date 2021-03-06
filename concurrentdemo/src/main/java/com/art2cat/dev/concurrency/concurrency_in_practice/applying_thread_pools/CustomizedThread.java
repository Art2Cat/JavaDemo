package com.art2cat.dev.concurrency.concurrency_in_practice.applying_thread_pools;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomizedThread extends Thread {

    public static final String DEFAULT_NAME = "CustomizedThread";
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();
    private static volatile boolean debugLifecycle = false;

    public CustomizedThread(Runnable r) {
        this(r, DEFAULT_NAME);
    }

    public CustomizedThread(Runnable runnable, String name) {
        super(runnable, name + "-" + created.incrementAndGet());
        setUncaughtExceptionHandler((t, e) -> log.log(Level.SEVERE,
            "UNCAUGHT in thread " + t.getName(), e));
    }

    public static int getThreadsCreated() {
        return created.get();
    }

    public static int getThreadsAlive() {
        return alive.get();
    }

    public static boolean getDebug() {
        return debugLifecycle;
    }

    public static void setDebug(boolean b) {
        debugLifecycle = b;
    }

    @Override
    public void run() {
        // Copy debug flag to ensure consistent value throughout.
        boolean debug = debugLifecycle;
        if (debug) {
            log.log(Level.FINE, "Created " + getName());
        }
        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) {
                log.log(Level.FINE, "Exiting " + getName());
            }
        }
    }
}
