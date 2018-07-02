package com.art2cat.dev.templatemethod;

/**
 * com.art2cat.dev.templatemethod
 *
 * @author art2c
 * @date 5/21/2018
 */
public abstract class AbstractDisplay {
    
    public abstract void open();
    
    public abstract void print();
    
    public abstract void close();
    
    public final void display() {
        open();
    
        for (int i = 0; i < 5; i++) {
            print();
        }
        
        close();
    }
}
