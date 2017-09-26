package com.art2cat.dev.multi_thread.chapterThree.inheritableThreadLocalTest;

import java.util.Date;

/**
 * Created by Rorschach
 * on 11/07/2017.
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        // childValue method could modify parentValue and add new Value
        return parentValue + " added in child Thread. ";
    }
}
