package com.art2cat.dev.multithread.chaptersix.dclSingleton;

/**
 * Created by Rorschach on 13/07/2017.
 */
public class MySingleton {

    private volatile static MySingleton singleton;

    private MySingleton() {
    }

    public static MySingleton newInstance() {
        if (singleton != null) {

        } else {
            synchronized (MySingleton.class) {
                if (singleton == null) {
                    singleton = new MySingleton();
                }
            }
        }

        return singleton;
    }
}
