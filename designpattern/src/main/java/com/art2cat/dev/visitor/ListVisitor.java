package com.art2cat.dev.visitor;

import com.art2cat.dev.composite.FileTreatmentException;
import java.util.Iterator;

/**
 * com.art2cat.dev.visitor
 *
 * @author art2c
 * @date 6/1/2018
 */
public class ListVisitor extends AbstractVisitor {
    
    private String currentDir = "";
    
    @Override
    public void visit(IElement element) {
        if (element instanceof File) {
            System.out.println(currentDir + "/" + element);
        } else if (element instanceof Directory) {
            System.out.println(currentDir + "/" + element);
            String saveDir = currentDir;
            currentDir = currentDir + "/" + element.getName();
            Iterator iterator = null;
            try {
                iterator = element.iterator();
                while (iterator.hasNext()) {
                    IElement next = (IElement) iterator.next();
                    next.accept(this);
                }
            } catch (FileTreatmentException e) {
                e.printStackTrace();
            }
            currentDir = saveDir;
        }
    }
}
