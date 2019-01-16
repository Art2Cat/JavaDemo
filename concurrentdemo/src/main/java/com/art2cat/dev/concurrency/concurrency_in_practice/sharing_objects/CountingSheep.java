package com.art2cat.dev.concurrency.concurrency_in_practice.sharing_objects;

/**
 * CountingSheep
 * <p/>
 * Counting sheep
 *
 * @author Brian Goetz and Tim Peierls
 */
public class CountingSheep {

    volatile boolean asleep;

    void tryToSleep() {
        while (!asleep) {
            countSomeSheep();
        }
    }

    void countSomeSheep() {
        // One, two, three...
    }
}








