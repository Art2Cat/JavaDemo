package com.art2cat.dev.concurrency.concurrency_in_practice.sharing_objects;

/**
 * ThisEscape
 * <p/>
 * Implicitly allowing the this reference to escape
 *
 * @author Brian Goetz and Tim Peierls
 */
public class ThisEscape {
    
    public ThisEscape(EventSource source) {
        source.registerListener(e -> doSomething(e));
    }
    
    void doSomething(Event e) {
    }
    
    
    interface EventSource {
        
        void registerListener(EventListener e);
    }
    
    interface EventListener {
        
        void onEvent(Event e);
    }
    
    interface Event {

    }
}

