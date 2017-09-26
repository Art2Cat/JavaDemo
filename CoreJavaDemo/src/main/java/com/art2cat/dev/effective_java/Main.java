package com.art2cat.dev.effective_java;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * Created by Rorschach
 * on 2017/2/8.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat = Cat.newInstance();
        cat.setAge(12);
        cat.setName("Art2cat");
        cat.setColor("white");
        cat.setYell("wang wang!");

        MammalianUtils.builder().with(cat).yell("Meow!");
        MammalianUtils.builder().with(cat).yell(null);

        String s1 = "fuck";
        String s2 = s1.intern();
        System.out.println(s1.equals(s2));

        WeakReference<Cat> catWeakReference = new WeakReference<Cat>(Cat.newInstance());
        catWeakReference.get().setName("Art2cat");
        System.out.println(cat.toString());
        System.out.println(catWeakReference.get().toString());
        System.out.println(Objects.equals(cat.toString(), catWeakReference.get().toString()));

        SoftReference<Thread> softReference = new SoftReference<Thread>(new Thread(() ->
                System.out.println(Thread.currentThread().getName())));
        if (softReference.get() != null) {
            try {
                softReference.get().start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
