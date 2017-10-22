package com.art2cat.dev.ch3;

import org.junit.Test;

public class AllocationTest {

    /**
     * JVM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    @Test
    public void testAllocation() {
        PracticeMemoryAllocation.allocation();
    }
}
