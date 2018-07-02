package com.art2cat.dev.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * com.art2cat.dev.flyweight
 *
 * @author art2c
 * @date 6/14/2018
 */
public class BigCharFactory {
    
    private Map<String, BigChar> pool = new HashMap<>();
    private static BigCharFactory singleton = new BigCharFactory();
    
    private BigCharFactory() {
    }
    
    public static BigCharFactory getInstance() {
        return singleton;
    }
    
    public synchronized BigChar getBigChar(char charName) {
        return pool.computeIfAbsent("" + charName, BigChar::new);
    }
}
