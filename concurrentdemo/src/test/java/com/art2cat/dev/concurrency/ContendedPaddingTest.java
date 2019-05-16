package com.art2cat.dev.concurrency;

import java.time.Duration;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * annotation {@code @Contended} is automatically padding the cache line of the variable use
 * -XX:-RestrictContended to enable @Contended annotation on custom class. use
 * -XX:ContendedPaddingWidth to set padding width, the default value is 128.
 */
class ContendedPaddingTest {

    private static final int LINE_NUM = 2048;
    private static final int COLUMN_NUM = 2048;

    private long[][] array;

    @BeforeEach
    private void init() {
        array = new long[LINE_NUM][COLUMN_NUM];
    }

    @Test
    void testContent() {
        var startTime = LocalTime.now();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++) {
                array[i][j] = i * 2 + j;
            }
        }
        var endTime = LocalTime.now();
        var cacheTime = Duration.between(startTime, endTime);
        System.out.println("cache time: " + cacheTime.toMillis() + " millisecond");
    }

    @Test
    void testContent2() {
        var startTime = LocalTime.now();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++) {
                array[j][i] = i * 2 + j;
            }
        }
        var endTime = LocalTime.now();
        var cacheTime = Duration.between(startTime, endTime);
        System.out.println("cache time: " + cacheTime.toMillis() + " millisecond");
    }
}
