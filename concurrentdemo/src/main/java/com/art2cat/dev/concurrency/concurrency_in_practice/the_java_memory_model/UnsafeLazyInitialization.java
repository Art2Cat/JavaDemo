package com.art2cat.dev.concurrency.concurrency_in_practice.the_java_memory_model;

/**
 * UnsafeLazyInitialization
 * <p/>
 * Unsafe lazy initialization
 *
 * @author Brian Goetz and Tim Peierls
 */
public class UnsafeLazyInitialization {
    
    private static Resource resource;
    
    public static Resource getInstance() {
        if (resource == null) {
            resource = new Resource(); // unsafe publication
        }
        return resource;
    }
    
    static class Resource {

    }
}
