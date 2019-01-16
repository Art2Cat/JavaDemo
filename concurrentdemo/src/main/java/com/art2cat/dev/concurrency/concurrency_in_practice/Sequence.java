package com.art2cat.dev.concurrency.concurrency_in_practice;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Sequence {

    @GuardedBy("this")
    private volatile Integer nextValue = 0;

    public Integer getNext() {
        synchronized (this) {
            return nextValue++;
        }
    }
}
