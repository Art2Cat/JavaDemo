package com.art2cat.dev.observer;

/**
 * com.art2cat.dev.observer
 *
 * @author art2c
 * @date 6/8/2018
 */
public interface IGenerator {

    void addObserver(IObserver observer);

    void deleteObserver(IObserver observer);

    void notifyObserver();

    int getNumber();

    void execute();
}
