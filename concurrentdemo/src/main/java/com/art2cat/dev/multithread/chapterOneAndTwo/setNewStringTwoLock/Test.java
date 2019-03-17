package com.art2cat.dev.multithread.chapterOneAndTwo.setNewStringTwoLock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rorschach on 7/7/2017.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");

        list.forEach(System.out::println);

        Thread a = new Thread(service::testMethod);
        a.setName("A");
        Thread b = new Thread(service::testMethod);
        b.setName("B");
        a.start();
        Thread.sleep(50);
        b.start();

    }
}
