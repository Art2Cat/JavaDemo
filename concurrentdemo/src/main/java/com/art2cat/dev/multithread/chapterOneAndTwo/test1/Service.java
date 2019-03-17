package com.art2cat.dev.multithread.chapterOneAndTwo.test1;

/**
 * Created by Rorschach on 7/7/2017.
 */
class Service {

    void testMethod(Object object) {
        synchronized (object) {
            try {
                System.out.println("testMethod ____getLock time= "
                    + System.currentTimeMillis() + "run ThreadName = "
                    + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod releaseLock time= "
                    + System.currentTimeMillis() + "run ThreadName = "
                    + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
