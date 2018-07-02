package com.art2cat.dev.iterator;

import com.art2cat.dev.singleton.Singleton;
import com.art2cat.dev.singleton.practice.Triple;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Assert;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/23/2018
 */
public class SingletonTest {
    
    @Test
    public void test() {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton1);
        Assert.assertEquals(singleton, singleton1);
    }
    
    @Test
    public void multiThreadTest() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            service
                .submit(() -> System.out.println(Thread.currentThread().getName() + " -> " + Singleton.getInstance()));
        }
        
        Thread.sleep(10000);
        if (!service.isTerminated()) {
            System.out.println("terminate the thread pool.");
            service.shutdown();
        }
    }
    
    @Test
    public void TripleTest() {
        Triple triple = Triple.getInstance(0);
        Triple triple1 = Triple.getInstance(1);
        Triple triple2 = Triple.getInstance(2);
        System.out.println(triple);
        System.out.println(triple1);
        System.out.println(triple2);
        Assert.assertEquals(triple, Triple.getInstance(0));
        Assert.assertEquals(triple1, Triple.getInstance(1));
        Assert.assertEquals(triple2, Triple.getInstance(2));
        
        try {
            Triple.getInstance(3);
            Assert.fail();
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
    
}
