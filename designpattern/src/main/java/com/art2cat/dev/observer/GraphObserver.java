package com.art2cat.dev.observer;

/**
 * com.art2cat.dev.observer
 *
 * @author art2c
 * @date 6/8/2018
 */
public class GraphObserver implements IObserver {
    
    @Override
    public void update(IGenerator generator) {
        System.out.println("GraphObserver: ");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(IGenerator generator, int number) {
        System.out.println("GraphObserver: ");
        
        int count = generator.getNumber() * number;
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(int number) {
        System.out.println("GraphObserver: ");
        for (int i = 0; i < number; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
