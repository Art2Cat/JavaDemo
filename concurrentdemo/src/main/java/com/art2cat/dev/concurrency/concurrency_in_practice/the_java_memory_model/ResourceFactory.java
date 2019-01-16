package com.art2cat.dev.concurrency.concurrency_in_practice.the_java_memory_model;

/**
 * ResourceFactory
 * <p/>
 * Lazy initialization holder class idiom
 *
 * @author Brian Goetz and Tim Peierls
 */
public class ResourceFactory {

    public static Resource getResource() {
        return ResourceFactory.ResourceHolder.resource;
    }

    private static class ResourceHolder {

        public static Resource resource = new Resource();
    }

    static class Resource {

    }
}
