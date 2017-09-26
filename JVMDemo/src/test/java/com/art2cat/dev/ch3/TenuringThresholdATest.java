package com.art2cat.dev.ch3;

import org.junit.Test;

public class TenuringThresholdATest {

    /**
     * JVM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     */
    @Test
    public void testTenuringThresholdA() {
        PracticeMemoryAllocation.tenuringThresholdA();
    }
}
