package com.art2cat.dev.visitor;

import com.art2cat.dev.composite.FileTreatmentException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * com.art2cat.dev.visitor
 *
 * @author art2c
 * @date 6/1/2018
 */
public class Directory extends AbstractEntry {
    
    private String name;
    private List<IElement> dir = new ArrayList<>();
    
    public Directory(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getSize() {
        return dir.stream().mapToInt(IElement::getSize).sum();
    }
    
    @Override
    public IElement add(IElement element) throws FileTreatmentException {
        dir.add(element);
        return this;
    }
    
    @Override
    public Iterator iterator() throws FileTreatmentException {
        return dir.iterator();
    }
    
    @Override
    public void accept(AbstractVisitor visitor) {
        visitor.visit(this);
    }
}
