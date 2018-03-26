package com.art2cat.dev.concurrency.concurrency_in_practice;

public class UnsafeSequence {
    
    private Integer value = 0;
    
    /**
     * Returns a unique value.
     */
    public Integer getNext() {
        return value++;
    }
}
