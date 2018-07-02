package com.art2cat.dev.observer;

/**
 * com.art2cat.dev.observer
 *
 * @author art2c
 * @date 6/8/2018
 */
public interface IObserver {
    
    void update(IGenerator generator);
    
    void update(IGenerator generator, int number);
    
    void update(int number);
}
