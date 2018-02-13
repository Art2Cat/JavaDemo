package com.art2cat.dev.jvm.ch3;

import org.junit.Test;

public class TenuringThresholdBTest {

    /**
     * JVM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=15
     */
    @Test
    public void testTenuringThresholdB() {
        PracticeMemoryAllocation.tenuringThresholdB();
    }
}
