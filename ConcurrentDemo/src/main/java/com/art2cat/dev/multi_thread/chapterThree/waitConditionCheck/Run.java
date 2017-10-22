package com.art2cat.dev.multi_thread.chapterThree.waitConditionCheck;

/**
 * Created by huang.yiming
 * on 7/10/2017.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Object lock= new Object();
        CustomList customList = new CustomList(lock);

        Thread subtract = new Thread(customList::subtract, "subtractThread");
        Thread subtract1 = new Thread(customList::subtract, "subtractThread1");
        subtract.start();
        subtract1.start();
        Thread.sleep(1000);

        Thread add = new Thread(() -> {
            customList.add("test");
        }, "addThread");

        add.start();
    }
}
