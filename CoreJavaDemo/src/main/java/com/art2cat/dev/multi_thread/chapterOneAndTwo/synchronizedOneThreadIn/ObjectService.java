package com.art2cat.dev.multi_thread.chapterOneAndTwo.synchronizedOneThreadIn;

/**
 * Created by Rorschach
 * on 7/7/2017.
 */
public class ObjectService {
    void serviceMethod() {
        try {
            // synchronized 代码块
            synchronized (this) {
                System.out.println("begin time= " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end time= " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
