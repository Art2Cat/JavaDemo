package com.art2cat.dev.concurrency.concurrency_in_practice.the_java_memory_model;

import net.jcip.annotations.ThreadSafe;

/**
 * EagerInitialization
 * <p/>
 * Eager initialization
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class EagerInitialization {
    
    private static Resource resource = new Resource();
    
    public static Resource getResource() {
        return resource;
    }
    
    static class Resource {
    
    }
}
