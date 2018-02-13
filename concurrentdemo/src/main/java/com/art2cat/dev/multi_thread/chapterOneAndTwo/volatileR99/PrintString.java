package com.art2cat.dev.multi_thread.chapterOneAndTwo.volatileR99;

/**
 * Created by Rorschach on 7/7/2017.
 */
public class PrintString {

    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    void printStringMethod() {
        try {
            while (isContinuePrint == true) {
                System.out.println("Run printStringMethod threadName = "
                    + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
