package com.art2cat.dev.thread;

public class KeyPersonThread extends Thread {
    
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Let's fight!");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "Attack...");
        }
        System.out.println(Thread.currentThread().getName() + "End fight...");
    }
}
