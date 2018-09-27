package com.art2cat.dev.corejava;

import java.util.TreeSet;
import org.junit.jupiter.api.Test;

public class TreeSetTest {
    
    @Test
    public void testTreeSet() {
        var treeSet = new TreeSet<String>();
        treeSet.add("A1");
        treeSet.add("Q2");
        treeSet.add("A1");
        treeSet.add("A1");
        treeSet.add("A2");
        treeSet.add("A5");
        treeSet.add("A3");
        
        treeSet.forEach(System.out::println);
    }
}
