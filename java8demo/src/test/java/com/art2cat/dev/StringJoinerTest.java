package com.art2cat.dev;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * com.art2cat.dev
 *
 * @author Rorschach
 * @date 28/12/2017
 */
public class StringJoinerTest {
    
    @Test
    public void test() {
        ArrayList<String> al = new ArrayList<>();
        
        al.add("Ram");
        al.add("Shyam");
        al.add("Alice");
        al.add("Bob");
        
        StringJoiner sj1 = new StringJoiner(",");
        
        // setEmptyValue() method
        sj1.setEmptyValue("sj1 is empty");
        System.out.println(sj1);
        
        // add() method
        for (String s : al) {
            sj1.add(s);
        }
        System.out.println(sj1);
        
        // length() method
        System.out.println("Length of sj1 : " + sj1.length());
        
        StringJoiner sj2 = new StringJoiner(":");
        sj2.add(al.get(2)).add(al.get(3));
        
        //merge() method
        sj1.merge(sj2);
        
        // toString() method
        System.out.println(sj1.toString());
        
        System.out.println("Length of new sj1 : " + sj1.length());
    }
    
    @Test
    public void test1() {
        ArrayList<String> al = new ArrayList<>();
    
        al.add("Ram");
        al.add("Shyam");
        al.add("Alice");
        al.add("Bob");
    
        String ss = al.stream().collect(Collectors.joining(","));
        System.out.println(ss);
    }
}
