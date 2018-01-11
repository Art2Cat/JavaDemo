package com.art2cat.dev.multi_thread.chapterOneAndTwo.test1;

/**
 * Created by Rorschach on 7/7/2017.
 */
public class RunTest {

    public static void main(String[] args) {
        // 使用了同一个"对象监视器"
        Service service = new Service();
        Object o = new Object();
        Thread a = new Thread(() -> {
            service.testMethod(o);
        });
        a.setName("A");
        a.start();

        Thread b = new Thread(() -> {
            service.testMethod(o);
        });
        b.setName("B");
        b.start();
    }
}
