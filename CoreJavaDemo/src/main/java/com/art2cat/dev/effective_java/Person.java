package com.art2cat.dev.effective_java;

import java.util.concurrent.Callable;

/**
 * Created by Rorschach
 * on 07/03/2017.
 */
public class Person {
    public Person() {
        System.out.println("this is a person");
    }

    public static void main(String[] args) {
        int i = 15;

        System.out.println(i+=i-=i*=i);

        MyThread1 myThread =  new MyThread1();
        System.out.println(Thread.currentThread().getName());
        new Thread(myThread).start();

    }

    static class MyThread1 implements Runnable{

        private MyThread1() {
            super();
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    static class MyCallable implements Callable {

        @Override
        public Object call() throws Exception {
            return null;
        }
    }
}
