package com.art2cat.dev.adapter;

/**
 * com.art2cat.dev.adapter class extend adapter
 *
 * @author art2c
 * @date 5/15/2018
 */
public class PrintBanner extends Banner implements IPrint {

    public PrintBanner(String content) {
        super(content);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
