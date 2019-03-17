package com.art2cat.dev.multithread.chapterOneAndTwo.stop_thread.suspend_resume;

/**
 * Created by Rorschach on 6/29/2017.
 */
public class MyThread extends Thread {

    private long id = 0;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            id++;
        }
    }
}
