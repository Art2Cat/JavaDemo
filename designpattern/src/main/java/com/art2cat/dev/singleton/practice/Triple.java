package com.art2cat.dev.singleton.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * com.art2cat.dev.Singleton.practice
 *
 * @author art2c
 * @date 5/23/2018
 */
public class Triple {

    private static Map<Integer, Triple> triples = new HashMap<>(3);

    private Triple() {
        System.out.println("init instance.");
    }

    public static Triple getInstance(int id) {
        if (id > 2) {
            throw new IndexOutOfBoundsException("Triple could create three instance only.");
        }
        return triples.computeIfAbsent(id, (integer -> new Triple()));
    }

}
