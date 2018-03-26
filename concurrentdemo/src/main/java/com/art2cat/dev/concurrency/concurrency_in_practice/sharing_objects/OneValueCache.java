package com.art2cat.dev.concurrency.concurrency_in_practice.sharing_objects;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * OneValueCache
 * <p/>
 * Immutable holder for caching a number and its factors
 *
 * @author Brian Goetz and Tim Peierls
 */

public class OneValueCache {
    
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;
    
    public OneValueCache(BigInteger i,
        BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }
    
    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}
