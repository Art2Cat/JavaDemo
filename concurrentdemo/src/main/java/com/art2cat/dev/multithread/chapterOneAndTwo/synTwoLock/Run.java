package com.art2cat.dev.multithread.chapterOneAndTwo.synTwoLock;

/**
 * Created by Rorschach on 7/7/2017.
 */
public class Run {

    public static void main(String[] args) {
        // synchronized加到static方法是给Class类上锁
        // 而加到非static方法则是给对象上锁.
        Service service = new Service();
        Thread a = new Thread(() -> {
            // printA()需要的Class锁, 而service对象持有的是对象锁
            Service.printA();
        });

        a.setName("A");
        a.start();
        Thread b = new Thread(() -> {
            Service.printB();
        });

        b.setName("B");
        b.start();
//        Thread c = new Thread(service::printC);
//        c.setName("C");
//        c.start();

    }
}
