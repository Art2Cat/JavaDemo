package com.art2cat.dev.concurrency.concurrency_in_practice.the_java_memory_model;


/**
 * EagerInitialization
 * <p/>
 * Eager initialization
 *
 * @author Brian Goetz and Tim Peierls
 */
public class EagerInitialization {

    private static Resource resource = new Resource();

    public static Resource getResource() {
        return resource;
    }

    static class Resource {

    }
}
