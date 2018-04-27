package com.art2cat.dev.corejava;

import com.art2cat.dev.effective_java.Cat;
import com.art2cat.dev.effective_java.LookUp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;

/**
 * com.art2cat.dev.corejava
 *
 * @author art2c
 * @date 4/27/2018
 */
public class AnnotationTest {
   
    @Test
    public void test() {
        try {
            Class<?> catClazz = Class.forName("com.art2cat.dev.effective_java.Cat");
            Cat cat = (Cat) catClazz.newInstance();
            for (Method method : catClazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(LookUp.class)) {
                    try {
                        method.invoke(cat, (Object[]) null);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
