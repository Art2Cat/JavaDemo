package com.art2cat.dev.flyweight;

import com.sun.istack.internal.NotNull;
import java.util.Arrays;

/**
 * com.art2cat.dev.flyweight
 *
 * @author art2c
 * @date 6/14/2018
 */
public class BigString {
    
    private BigChar[] bigChars;
    
    public BigString(@NotNull String string) {
        bigChars = new BigChar[string.length()];
        BigCharFactory bigCharFactory = BigCharFactory.getInstance();
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i] = bigCharFactory.getBigChar(string.charAt(i));
        }
    }
    
    public void print() {
        Arrays.stream(bigChars).forEachOrdered(BigChar::print);
    }
    
}
