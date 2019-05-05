package com.art2cat.dev.composite;

/**
 * com.art2cat.dev.composite
 *
 * @author art2c
 * @date 5/30/2018
 */
public abstract class AbstractEntry {

    protected abstract String getParentPath();

    protected abstract void setParentPath(String parentPath);

    public abstract String getName();

    public abstract int getSize();

    public AbstractEntry add(AbstractEntry abstractEntry) throws FileTreatmentException {
        throw new FileTreatmentException("Please override this method before invoke it.");
    }

    public void printList() {
        printList("");
    }

    public String getPath() {
        return getParentPath() + getName();
    }


    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
