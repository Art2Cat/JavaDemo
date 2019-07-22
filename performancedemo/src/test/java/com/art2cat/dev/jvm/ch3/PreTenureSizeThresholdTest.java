package com.art2cat.dev.jvm.ch3;


import org.junit.jupiter.api.Test;

public class PreTenureSizeThresholdTest {

    /**
     * JVM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    @Test
    public void testPreTenureSizeThreshold() {
        PracticeMemoryAllocation.preTenureSizeThreshold();
    }
}
