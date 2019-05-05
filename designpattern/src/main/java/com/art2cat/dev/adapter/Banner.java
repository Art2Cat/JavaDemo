package com.art2cat.dev.adapter;

/**
 * com.art2cat.dev.adapter
 *
 * @author art2c
 * @date 5/15/2018
 */
public class Banner implements IBanner {

    private String content;

    public Banner(String content) {
        this.content = content;
    }

    @Override
    public void showWithParen() {
        System.out.println(String.format("(%s)", content));
    }

    @Override
    public void showWithAster() {
        System.out.println(String.format("*%s*", content));
    }
}
