package com.art2cat.dev.multithread.chapterOneAndTwo.volatileR99;


/**
 * Created by Rorschach on 7/7/2017.
 */
public class MainRun {

    public static void main(String[] args) {
        PrintString printString = new PrintString();

        new Thread(printString::printStringMethod).start();
//        printString.printStringMethod();
        System.out.println("我要停止它! stopThread=" + Thread.currentThread().getName());
        printString.setContinuePrint(false);

    }
}
