package com.art2cat.dev.iterator;

import com.art2cat.dev.observer.DigitObserver;
import com.art2cat.dev.observer.GraphObserver;
import com.art2cat.dev.observer.IGenerator;
import com.art2cat.dev.observer.IObserver;
import com.art2cat.dev.observer.RandomNumberGenerator;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 6/8/2018
 */
public class ObserverTest {
    
    @Test
    public void test() {
        IGenerator generator = new RandomNumberGenerator();
        
        IObserver observer = new DigitObserver();
        IObserver observer1 = new GraphObserver();
        
        generator.addObserver(observer);
        generator.addObserver(observer1);
        
        generator.execute();
    }
    
}
