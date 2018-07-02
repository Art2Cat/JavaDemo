package com.art2cat.dev.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * com.art2cat.dev.composite
 *
 * @author art2c
 * @date 5/30/2018
 */
public class Directory extends AbstractEntry {
    
    private String name;
    
    private String parentPath;
    private List<AbstractEntry> directory = new ArrayList<>();
    
    public Directory(String name) {
        this.name = name;
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
        return directory.stream().mapToInt(AbstractEntry::getSize).sum();
    }
    
    @Override
    public AbstractEntry add(AbstractEntry abstractEntry) throws FileTreatmentException {
        abstractEntry.setParentPath(getParentPath() + name + "/");
        directory.add(abstractEntry);
        return this;
    }
    
    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        directory.forEach(abstractEntry -> abstractEntry.printList(prefix + "/" + name));
    }
}
