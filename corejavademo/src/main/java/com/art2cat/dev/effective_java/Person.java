package com.art2cat.dev.effective_java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Rorschach on 07/03/2017.
 */
public class Person {
    
    public Person() {
        System.out.println(Thread.currentThread().getName() + " this is a person");
    }
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int i = 15;
        
        System.out.println(i += i -= i *= i);
        
        MyThread1 myThread = new MyThread1();
        System.out.println(Thread.currentThread().getName());
        new Thread(myThread).start();
        
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Person> task = executorService.submit(new MyCallable<>());
        Thread.sleep(1000);
        if (task.isDone()) {
            Person person = task.get();
            System.out.println(person);
        } else {
            System.out.println("failed");
        }
        
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
        
    }
    
    static class MyThread1 implements Runnable {
        
        private MyThread1() {
            super();
        }
        
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
    
    static class MyCallable<Object> implements Callable<Object> {
        
        @Override
        @SuppressWarnings("unchecked")
        public Object call() throws Exception {
            Person person = new Person();
            return (Object) person;
        }
    }
    
    @Override
    public String toString() {
        return "Person{}";
    }
}
