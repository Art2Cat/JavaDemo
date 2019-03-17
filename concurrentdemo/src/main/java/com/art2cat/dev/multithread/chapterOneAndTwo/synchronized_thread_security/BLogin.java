package com.art2cat.dev.multithread.chapterOneAndTwo.synchronized_thread_security;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class BLogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}
