package com.art2cat.dev;

/**
 * com.art2cat.dev
 *
 * @author rorschach
 * @date 3/29/18
 */
public interface IDuck {
    
    default void quack() {
        System.out.println("Quack");
    }
}
