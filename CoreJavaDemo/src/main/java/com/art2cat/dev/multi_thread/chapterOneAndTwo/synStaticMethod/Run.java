package com.art2cat.dev.multi_thread.chapterOneAndTwo.synStaticMethod;

/**
 * Created by Rorschach
 * on 7/7/2017.
 */
public class Run {
    public static void main(String[] args) {
        // synchronized加到static方法是给Class类上锁
        // 而加到非static方法则是给对象上锁.
        Thread a = new Thread(Service::printA);
        a.setName("A");
        a.start();
        Thread b = new Thread(Service::printB);
        b.setName("B");
        b.start();
    }
}
