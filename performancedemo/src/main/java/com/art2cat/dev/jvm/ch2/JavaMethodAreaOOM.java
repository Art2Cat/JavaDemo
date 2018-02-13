package com.art2cat.dev.jvm.ch2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M Java 8 JVM args: -XX:MetaspaceSize=10M
 * -XX:MaxMetaspaceSize=10m
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        try {
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMObject.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(
                    (MethodInterceptor)
                        (o, method, objects, methodProxy) ->
                            methodProxy.invokeSuper(o, objects));
                enhancer.create();
            }
        } catch (Throwable e) {
            throw e;
        }
        // Method Area is difference with RuntimeConstants Pool, it will get Metaspace error in JDK 8.
    }

    static class OOMObject {

    }
}
