package com.art2cat.dev.multithread.chapterOneAndTwo.synchronized_thread_security;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class ALogin extends Thread {

    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("a", "aa");
    }
}
