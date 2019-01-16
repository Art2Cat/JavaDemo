package com.art2cat.dev.multi_thread.chapterOneAndTwo.synBlockString;

/**
 * Created by Rorschach on 7/7/2017.
 */
class Service {

    String usernameParam;
    String passwordParam;
    String anyString = "";

    void setUsernamePassword(String username, String password) {
        try {
            synchronized (this) {
                System.out.println("Thread name: " + Thread.currentThread().getName()
                    + " at " + System.currentTimeMillis() + " enter synchronized block");
                usernameParam = username;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println("Thread name: " + Thread.currentThread().getName()
                    + " at " + System.currentTimeMillis() + " quit synchronized block");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void test() {
        try {
            synchronized (anyString) {
                System.out.println("a begin");
                Thread.sleep(3000);
                System.out.println("a end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void b() {
        System.out.println("b begin");
        System.out.println("b end");
    }
}
