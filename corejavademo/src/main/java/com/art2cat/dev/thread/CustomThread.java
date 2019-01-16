package com.art2cat.dev.thread;

/**
 * Created by Rorschach on 2017/3/29.
 */
public class CustomThread extends Thread {

    private int count = 10;

    public CustomThread(String name) {
        super();
        this.setName(name);
    }

    public CustomThread(Runnable target, String name) {
        super(target);
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();

        count--;
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }
}
