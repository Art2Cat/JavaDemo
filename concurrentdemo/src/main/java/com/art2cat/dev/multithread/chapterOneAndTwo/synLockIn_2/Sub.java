package com.art2cat.dev.multithread.chapterOneAndTwo.synLockIn_2;

/**
 * Created by Rorschach on 7/6/2017.
 */
public class Sub extends Main {

    void operateISubMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
