package com.art2cat.dev.multi_thread.chapterOneAndTwo.throwExceptionNoLock;

/**
 * Created by Rorschach
 * on 7/6/2017.
 */
class Service {
    synchronized void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName = " + Thread.currentThread().getName()
                    + " run beginTime= " + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThreadName = " + Thread.currentThread().getName()
                            + " run exceptionTime= " + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread B run Time=" +
                    System.currentTimeMillis());
        }
    }
}
