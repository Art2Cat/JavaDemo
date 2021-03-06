package com.art2cat.dev.concurrency.concurrency_in_practice.the_java_memory_model;

import java.util.HashMap;
import java.util.Map;

/**
 * SafeStates
 * <p/>
 * Initialization safety for immutable objects
 *
 * @author Brian Goetz and Tim Peierls
 */
public class SafeStates {

    private final Map<String, String> states;

    public SafeStates() {
        states = new HashMap<String, String>();
        states.put("alaska", "AK");
        states.put("alabama", "AL");
        /*...*/
        states.put("wyoming", "WY");
    }

    public String getAbbreviation(String s) {
        return states.get(s);
    }
}
