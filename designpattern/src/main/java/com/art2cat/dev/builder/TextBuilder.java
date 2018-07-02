package com.art2cat.dev.builder;

/**
 * com.art2cat.dev.builder
 *
 * @author art2c
 * @date 5/24/2018
 */
public class TextBuilder extends AbstractBuilder {
    
    private StringBuffer buffer = new StringBuffer();
    
    @Override
    public void makeTitle(String title) {
        buffer.append("====================================\n");
        buffer.append("[" + title + "]\n");
        buffer.append("\n");
    }
    
    @Override
    public void makeString(String str) {
        buffer.append("⬛" + str + "\n");
        buffer.append("\n");
    }
    
    @Override
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append("   ." + items[i] + "\n");
        }
        buffer.append("\n");
    }
    
    @Override
    public void close() {
        buffer.append("====================================\n");
    }
    
    public String getResult() {
        return buffer.toString();
    }
}
