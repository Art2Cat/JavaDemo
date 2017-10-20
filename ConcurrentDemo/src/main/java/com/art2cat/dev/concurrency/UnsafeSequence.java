package com.art2cat.dev.concurrency;

import net.jcip.annotations.*;

@NotThreadSafe
public class UnsafeSequence {
	private Integer value = 0;

	/**
	 * Returns a unique value.
	 */
	public Integer getNext() {
		return value++;
	}
}
