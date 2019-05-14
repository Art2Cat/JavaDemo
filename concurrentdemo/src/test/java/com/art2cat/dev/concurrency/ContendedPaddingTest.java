package com.art2cat.dev.concurrency;

import org.junit.jupiter.api.Test;

/**
 * annotation {@code @Contended} is automatically padding the cache line of the variable use
 * -XX:-RestrictContended to enable @Contended annotation on custom class. use
 * -XX:ContendedPaddingWidth to set padding width, the default value is 128.
 */
class ContendedPaddingTest {

    private static final int LINE_NUM = 2048;
    private static final int COLUMN_NUM = 2048;


    @Test
    void testContent() {

        long[][] array = new long[LINE_NUM][COLUMN_NUM];
        var startTime = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++) {
                array[i][j] = i * 2 + j;
            }
        }
        var endTime = System.currentTimeMillis();
        long cacheTime = endTime - startTime;
        System.out.println("cache time: " + cacheTime);
    }

    @Test
    void testContent2() {

        long[][] array = new long[LINE_NUM][COLUMN_NUM];
        var startTime = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++) {
                array[j][i] = i * 2 + j;
            }
        }
        var endTime = System.currentTimeMillis();
        long cacheTime = endTime - startTime;
        System.out.println("no cache time: " + cacheTime);
    }

}
