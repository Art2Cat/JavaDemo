package com.art2cat.dev.multithread.chapterOneAndTwo.stop_thread.stop;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class Main {

    public static void main(String[] args) {
        SynchronizedObject object = new SynchronizedObject();
        TestThread testThread = new TestThread(object);
        testThread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //deprecated
        testThread.stop();
        System.out.println(object.getUsername() + ": " +
            object.getPassword());
    }
}

class TestThread extends Thread {

    private SynchronizedObject object;

    TestThread(SynchronizedObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.printString("b", "bb");
    }
}