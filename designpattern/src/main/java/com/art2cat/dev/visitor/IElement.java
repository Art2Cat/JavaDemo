package com.art2cat.dev.visitor;

import com.art2cat.dev.composite.FileTreatmentException;
import java.util.Iterator;

/**
 * com.art2cat.dev.visitor
 *
 * @author art2c
 * @date 6/1/2018
 */
public interface IElement {
    
    String getName();
    
    int getSize();
    
    void accept(AbstractVisitor visitor);
    
    
    public IElement add(IElement element) throws FileTreatmentException;
    
    Iterator iterator() throws FileTreatmentException;
}
