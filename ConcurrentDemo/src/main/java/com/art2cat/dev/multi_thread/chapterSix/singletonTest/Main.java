package com.art2cat.dev.multi_thread.chapterSix.singletonTest;

import com.art2cat.dev.corejava.iostream.FileUtils;

/**
 * Created by Rorschach
 * on 13/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println(FileUtils.get().hashCode()));
        Thread thread1 = new Thread(() -> System.out.println(FileUtils.getInstance().hashCode()));
        Thread thread2 = new Thread(() -> System.out.println(FileUtils.getUtil().hashCode()));
        thread.start();
        thread1.start();
        thread2.start();
    }
}
