package com.art2cat.dev.chainofresponsibility;

/**
 * com.art2cat.dev.chainofresponsibility
 *
 * @author art2c
 * @date 6/4/2018
 */
public abstract class AbstractSupport {
    
    private String name;
    private AbstractSupport next;
    
    public AbstractSupport(String name) {
        this.name = name;
    }
    
    public AbstractSupport setNext(AbstractSupport next) {
        this.next = next;
        return next;
    }
    
    protected abstract boolean resolve(ITrouble trouble);
    
    protected void done(ITrouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }
    
    protected void fail(ITrouble trouble) {
        System.out.println(trouble + " can't be resolved.");
    }
    
    public final void support(ITrouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }
    
    @Override
    public String toString() {
        return "AbstractSupport{" +
            "name='" + name + '\'' +
            '}';
    }
}
