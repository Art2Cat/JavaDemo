package com.art2cat.dev.visitor;

import com.art2cat.dev.composite.FileTreatmentException;
import java.util.Iterator;

/**
 * com.art2cat.dev.visitor
 *
 * @author art2c
 * @date 6/1/2018
 */
public abstract class AbstractEntry implements IElement {
    
    @Override
    public IElement add(IElement element) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    
    @Override
    public Iterator iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
