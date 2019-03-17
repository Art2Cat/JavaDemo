package com.art2cat.dev.multithread.chapterOneAndTwo.t1;

/**
 * Created by Rorschach on 7/6/2017.
 */
class HasSelfPrivateNum {

    void addI(String username) {
        try {
            // 方法内变量是线程安全的
            int num = 0;
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
