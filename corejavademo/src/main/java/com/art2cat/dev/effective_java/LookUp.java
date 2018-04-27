package com.art2cat.dev.effective_java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * com.art2cat.dev.effective_java
 *
 * @author art2c
 * @date 4/27/2018
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LookUp {
    
}
