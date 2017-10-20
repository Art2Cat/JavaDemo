package com.art2cat.dev.ch7;

import com.art2cat.dev.ClassLoaderA;
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
                    fileName = fileName + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
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

        System.out.println(object instanceof com.art2cat.dev.ch7.ClassLoaderTest);
    }

    @Test
	public void test1() {
	    System.setProperty("art2cat.classloader", "class");
	    System.out.println(ClassLoaderA.getClassLoader().getResource("."));
	    System.out.println(ClassLoaderA.getClassLoader().toString());

	    System.setProperty("art2cat.classloader", "thread");
	    System.out.println(ClassLoaderA.getClassLoader().getResource("."));
	    System.out.println(ClassLoaderA.getClassLoader().toString());
    }
}
