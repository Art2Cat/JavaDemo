package com.art2cat.dev.multi_thread.chapterSix.serializableSingleton;

import java.io.Serializable;

/**
 * Created by Rorschach on 13/07/2017.
 */
public class SerializableObject implements Serializable {

    private static final long serialVersionUID = 1024L;

    private SerializableObject() {
    }

    static SerializableObject getInstance() {
        return ObjectHandler.object;
    }

    protected Object readResolve() {
        System.out.println("invoke readResolve()");
        return ObjectHandler.object;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private static class ObjectHandler {

        private static final SerializableObject object = new SerializableObject();
    }
}
