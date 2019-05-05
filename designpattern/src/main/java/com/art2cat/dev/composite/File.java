package com.art2cat.dev.composite;

/**
 * com.art2cat.dev.composite
 *
 * @author art2c
 * @date 5/30/2018
 */
public class File extends AbstractEntry {

    private String name;
    private int size;
    private String parentPath;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    protected String getParentPath() {
        return parentPath == null ? "/" : parentPath;
    }

    @Override
    protected void setParentPath(String parentPath) {
        this.parentPath = parentPath;
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
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }


}
