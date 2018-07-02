package com.art2cat.dev.adapter;

/**
 * com.art2cat.dev.adapter
 *
 * @author art2c
 * @date 5/15/2018
 */
public class PrintAdapter implements IPrint {
    
    private INotification notification;
    
    public PrintAdapter(INotification notification) {
        this.notification = notification;
    }
    
    @Override
    public void printWeak() {
        notification.showWithParen();
    }
    
    @Override
    public void printStrong() {
        notification.showWithAster();
    }
}
