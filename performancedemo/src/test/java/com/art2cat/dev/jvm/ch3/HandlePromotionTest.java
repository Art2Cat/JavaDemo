package com.art2cat.dev.jvm.ch3;


import org.junit.jupiter.api.Test;

public class HandlePromotionTest {

    /**
     * This test need earlier JDK 6 update 24. JVM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M
     * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
     */
    @Test
    public void testHandlePromotion() {
        PracticeMemoryAllocation.handlePromotion();
    }
}
