package com.art2cat.dev.multi_thread.chapterThree.wait_notify_insert_test;

/**
 * Created by Rorschach on 10/07/2017.
 */
public class Run {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 5; i++) {
            Thread backupB = new Thread(dbTools::backupB);
            backupB.start();
            Thread backupA = new Thread(dbTools::backupA);
            backupA.start();
        }
    }
}
