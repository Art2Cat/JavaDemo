package com.art2cat.dev.multi_thread.chapterThree.stack_one;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rorschach on 10/07/2017.
 */
class Stack {

    private List<String> list = new ArrayList<>();

    synchronized void push() {
        try {
            if (list.size() == 1) {
                this.wait();
            }
            list.add("anyString" + Math.random());
            this.notify();
            System.out.println("Push: " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized String pop() {
        String returnValue = "";
        try {
            if (list.size() == 0) {
                System.out.println("pop操作中的： " + Thread.currentThread().getName() + " 线程处于wait状态");
                this.wait();
            }
            returnValue = list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("Pop: " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
