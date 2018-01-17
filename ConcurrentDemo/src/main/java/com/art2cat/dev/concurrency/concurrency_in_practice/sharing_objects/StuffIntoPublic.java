package com.art2cat.dev.concurrency.concurrency_in_practice.sharing_objects;

/**
 * StuffIntoPublic
 * <p/>
 * Unsafe publication
 *
 * @author Brian Goetz and Tim Peierls
 */
public class StuffIntoPublic {
    
    public Holder holder;
    
    public void initialize() {
        holder = new Holder(42);
    }
}
