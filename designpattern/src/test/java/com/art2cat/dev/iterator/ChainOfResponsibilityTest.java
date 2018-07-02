package com.art2cat.dev.iterator;

import com.art2cat.dev.chainofresponsibility.AbstractSupport;
import com.art2cat.dev.chainofresponsibility.LimitSupport;
import com.art2cat.dev.chainofresponsibility.NoSupport;
import com.art2cat.dev.chainofresponsibility.OddSupport;
import com.art2cat.dev.chainofresponsibility.SpecialSupport;
import com.art2cat.dev.chainofresponsibility.Trouble;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 6/4/2018
 */
public class ChainOfResponsibilityTest {
    
    @Test
    public void test() {
        AbstractSupport alice = new NoSupport("Alice");
        AbstractSupport bob = new LimitSupport("Bob", 100);
        AbstractSupport charlie = new SpecialSupport("Charlie", 429);
        AbstractSupport diana = new LimitSupport("Diana", 200);
        AbstractSupport elmo = new OddSupport("Elmo");
        AbstractSupport fred = new LimitSupport("fred", 300);
        
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
            
        }
        
        
    }
    
}
