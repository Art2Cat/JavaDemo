package com.art2cat.dev.visitor;

/**
 * com.art2cat.dev.visitor
 *
 * @author art2c
 * @date 6/1/2018
 */
public class File extends AbstractEntry {
    
    private String name;
    private int size;
    
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getSize() {
        return size;
    }
    
    @Override
    public void accept(AbstractVisitor visitor) {
        visitor.visit(this);
    }
    
}
