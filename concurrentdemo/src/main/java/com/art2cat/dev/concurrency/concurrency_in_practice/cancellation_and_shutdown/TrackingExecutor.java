package com.art2cat.dev.concurrency.concurrency_in_practice.cancellation_and_shutdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TrackingExecutor
 * <p/>
 * ExecutorService that keeps track of cancelled tasks after shutdown
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TrackingExecutor extends AbstractExecutorService {
    
    private final ExecutorService exec;
    private final Set<Runnable> tasksCancelledAtShutdown =
        Collections.synchronizedSet(new HashSet<Runnable>());
    
    public TrackingExecutor(ExecutorService exec) {
        this.exec = exec;
    }
    
    @Override
    public void shutdown() {
        exec.shutdown();
    }
    
    @Override
    public List<Runnable> shutdownNow() {
        return exec.shutdownNow();
    }
    
    @Override
    public boolean isShutdown() {
        return exec.isShutdown();
    }
    
    @Override
    public boolean isTerminated() {
        return exec.isTerminated();
    }
    
    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit)
        throws InterruptedException {
        return exec.awaitTermination(timeout, unit);
    }
    
    public List<Runnable> getCancelledTasks() {
        if (!exec.isTerminated()) {
            throw new IllegalStateException(/*...*/);
        }
        return new ArrayList<>(tasksCancelledAtShutdown);
    }
    
    @Override
    public void execute(final Runnable runnable) {
        exec.execute(() -> {
            try {
                runnable.run();
            } finally {
                if (isShutdown()
                    && Thread.currentThread().isInterrupted()) {
                    tasksCancelledAtShutdown.add(runnable);
                }
            }
        });
    }
}
