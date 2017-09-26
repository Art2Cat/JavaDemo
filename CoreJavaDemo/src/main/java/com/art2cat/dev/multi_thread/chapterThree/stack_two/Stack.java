package com.art2cat.dev.multi_thread.chapterThree.stack_two;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rorschach
 * on 10/07/2017.
 */
public class Stack {
    private List<String> list = new ArrayList<String>();

    public synchronized void push() {
        try {
            // use while instead of if statement to avoid exception
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anyString" + Math.random());
            // use notifyAll() avoid "fake dead"
            this.notifyAll();
            System.out.println("Push: " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String pop() {
        String returnValue = "";
        try {
            // use while instead of if statement to avoid exception
            while (list.size() == 0) {
                System.out.println("pop操作中的： " + Thread.currentThread().getName() + " 线程处于wait状态");
                this.wait();
            }
            returnValue = list.get(0).toString();
            list.remove(0);
            // use notifyAll() avoid "fake dead"
            this.notifyAll();
            System.out.println("Pop: " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
