package com.art2cat.dev.corejava;

import com.art2cat.dev.effective_java.Cat;
import com.art2cat.dev.effective_java.LookUp;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
            Constructor<?> constructor = catClazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Cat cat = (Cat) constructor.newInstance();
            cat.setYell("meow");
            for (Method method : catClazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(LookUp.class)) {

                    Object yell = method.invoke(cat, (Object[]) null);
                    Assertions.assertEquals("meow", yell);
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException |
            InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            Assertions.fail();
        }
    }
}
