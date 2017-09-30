package com.art2cat.dev.ch7;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1);

                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        System.out.println("parent");
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object = classLoader.loadClass("com.art2cat.dev.ch7.ClassLoaderTest").newInstance();

        System.out.println(object.getClass());

        // why result is true on jdk 8?
        System.out.println(object instanceof com.art2cat.dev.ch7.ClassLoaderTest);
    }
}
