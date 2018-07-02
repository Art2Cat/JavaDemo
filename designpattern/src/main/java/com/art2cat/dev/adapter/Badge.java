package com.art2cat.dev.adapter;

/**
 * com.art2cat.dev.adapter
 *
 * @author art2c
 * @date 5/15/2018
 */
public class Badge implements INotification {
    
    private String content;
    
    public Badge(String content) {
        this.content = content;
    }
    
    @Override
    public void showWithParen() {
        System.out.println("+++++" + content);
    }
    
    @Override
    public void showWithAster() {
        System.out.println(content + "----->");
    }
}
