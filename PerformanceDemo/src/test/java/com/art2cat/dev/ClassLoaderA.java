package com.art2cat.dev;

public class ClassLoaderA {


    public static ClassLoader getClassLoader() {
        System.out.println(System.getProperty("art2cat.classloader", "thread"));
        if (System.getProperty("art2cat.classloader", "thread").equals("class")) {
            return ClassLoaderA.class.getClassLoader().getParent();
        } else {
            return Thread.currentThread().getContextClassLoader();
        }
    }
}
