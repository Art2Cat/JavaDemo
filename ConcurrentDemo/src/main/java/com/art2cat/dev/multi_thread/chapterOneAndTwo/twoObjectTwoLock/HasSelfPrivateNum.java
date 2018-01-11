package com.art2cat.dev.multi_thread.chapterOneAndTwo.twoObjectTwoLock;

/**
 * Created by Rorschach on 7/6/2017.
 */
class HasSelfPrivateNum {

    // 实例变量是非线程安全的
    private int num = 0;

    // 通过添加 synchronized 关键字来实现线程安全
    synchronized void addI(String username) {
        try {
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
