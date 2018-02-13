package com.art2cat.dev.concurrency.concurrency_in_practice.sharing_objects;

import java.util.HashSet;
import java.util.Set;

/**
 * Secrets
 *
 * Publishing an object
 *
 * @author Brian Goetz and Tim Peierls
 */
class Secrets {
    
    public static Set<Secret> knownSecrets;
    
    public void initialize() {
        knownSecrets = new HashSet<Secret>();
    }
}


class Secret {

}
