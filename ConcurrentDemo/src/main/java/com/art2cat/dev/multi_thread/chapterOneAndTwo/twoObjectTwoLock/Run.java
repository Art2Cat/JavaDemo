package com.art2cat.dev.multi_thread.chapterOneAndTwo.twoObjectTwoLock;


/**
 * Created by Rorschach on 7/6/2017.
 */
public class Run {

    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        Thread threadA = new Thread(() -> {
            numRef.addI("a");
        });
        threadA.start();
        Thread threadB = new Thread(() -> {
            numRef2.addI("b");
        });
        threadB.start();
    }
}
