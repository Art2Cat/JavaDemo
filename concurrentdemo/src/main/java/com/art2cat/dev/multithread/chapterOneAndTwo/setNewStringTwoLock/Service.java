package com.art2cat.dev.multithread.chapterOneAndTwo.setNewStringTwoLock;

/**
 * Created by Rorschach on 7/7/2017.
 */
class Service {

    String lock = "Lock";

    void testMethod() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() +
                    " begin " + System.currentTimeMillis());
                lock = "LockB";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() +
                    " end " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
