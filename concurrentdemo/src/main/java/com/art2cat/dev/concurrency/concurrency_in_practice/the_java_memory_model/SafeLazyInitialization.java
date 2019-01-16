package com.art2cat.dev.concurrency.concurrency_in_practice.the_java_memory_model;

/**
 * SafeLazyInitialization
 * <p/>
 * Thread-safe lazy initialization
 *
 * @author Brian Goetz and Tim Peierls
 */
public class SafeLazyInitialization {

    private static Resource resource;

    public synchronized static Resource getInstance() {
        if (resource == null) {
            resource = new Resource();
        }
        return resource;
    }

    static class Resource {

    }
}
