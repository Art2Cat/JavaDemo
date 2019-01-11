package com.art2cat.dev.corejava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.corejava
 *
 * @author rorschach
 * @date 3/26/18
 */
public class ThreadLocalTest {

    private ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    private Runnable runnable = () -> IntStream.range(0, 5).forEach(i -> System.out
        .println(String
            .format("Thread: %s, value: %d", Thread.currentThread().getName(), getNextNum())));

    private int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    @Test
    public void testThreadLocal() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        IntStream.range(0, 5).forEach(i -> {
            if (!executor.isTerminated()) {
                executor.execute(runnable);
            }
        });

        executor.shutdown();
    }


}
