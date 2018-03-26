package com.art2cat.dev.concurrency.concurrency_in_practice.the_java_memory_model;

/**
 * DoubleCheckedLocking
 * <p/>
 * Double-checked-locking antipattern
 *
 * @author Brian Goetz and Tim Peierls
 */
public class DoubleCheckedLocking {
    
    private static Resource resource;
    
    public static Resource getInstance() {
        if (resource == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (resource == null) {
                    resource = new Resource();
                }
            }
        }
        return resource;
    }
    
    static class Resource {

    }
}
