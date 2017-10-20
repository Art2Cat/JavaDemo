package com.art2cat.dev.concurrency;

import net.jcip.annotations.*;

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
