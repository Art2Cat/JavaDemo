package com.art2cat.dev.java8;

import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev
 *
 * @author rorschach
 * @date 3/29/18
 */
public class ReflectInterfaceDefaultMethodTest {
    
    @Test
    public void testNormal() {
        ICat cat = (ICat) Proxy.newProxyInstance(
            Thread.currentThread().getContextClassLoader(),
            new Class[]{ICat.class},
            (proxy, method, args) -> {
                System.out.println("meow");
                return null;
            }
        );
        
        cat.meow();
    }
    
    /**
     * use MethodHandles.Lookup to get Interface's default method
     */
    @Test
    public void testMethodHandlesToGetDefaultMethod() {
        IDuck duck = (IDuck) Proxy.newProxyInstance(
            Thread.currentThread().getContextClassLoader(),
            new Class[]{IDuck.class},
            (proxy, method, args) -> {
                Constructor<Lookup> constructor = Lookup.class
                    .getDeclaredConstructor(Class.class);
                constructor.setAccessible(true);
                constructor.newInstance(IDuck.class)
                    .in(IDuck.class)
                    .unreflectSpecial(method, IDuck.class)
                    .bindTo(proxy)
                    .invokeWithArguments();
                return null;
            }
        );
        
        duck.quack();
    }
}
