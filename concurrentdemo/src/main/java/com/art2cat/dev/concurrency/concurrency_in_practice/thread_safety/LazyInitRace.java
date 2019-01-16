package com.art2cat.dev.concurrency.concurrency_in_practice.thread_safety;

/**
 * LazyInitRace
 *
 * Race condition in lazy initialization Negative
 *
 * @author Brian Goetz and Tim Peierls
 */


public class LazyInitRace {

    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }
}

class ExpensiveObject {

}

