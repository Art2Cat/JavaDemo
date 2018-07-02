package com.art2cat.dev.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * com.art2cat.dev.observer
 *
 * @author art2c
 * @date 6/8/2018
 */
public abstract class AbstractNumberGenerator implements IGenerator {
    
    private List<IObserver> observerList = new ArrayList<>();
    
    
    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }
    
    @Override
    public void deleteObserver(IObserver observer) {
        observerList.remove(observer);
    }
    
    @Override
    public void notifyObserver() {
        observerList.forEach(observer -> observer.update(this, 2));
    }
}
