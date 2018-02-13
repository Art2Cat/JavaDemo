package com.art2cat.dev.multi_thread.chapterOneAndTwo.synchronized_thread_security;

/**
 * Created by Rorschach on 6/28/2017.
 */
public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    // synchronized 关键字 解决 非线程安全
    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username = " + usernameRef + ", password = " + passwordRef);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
