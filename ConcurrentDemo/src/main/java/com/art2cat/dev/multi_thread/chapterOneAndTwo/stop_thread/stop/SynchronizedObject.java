package com.art2cat.dev.multi_thread.chapterOneAndTwo.stop_thread.stop;

/**
 * Created by Rorschach on 6/29/2017.
 */
public class SynchronizedObject {

    private String username = "test";
    private String password = "test password";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
