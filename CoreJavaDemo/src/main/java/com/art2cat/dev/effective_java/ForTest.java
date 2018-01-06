package com.art2cat.dev.effective_java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Rorschach on 06/03/2017.
 */
public class ForTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        new Thread(() -> {
            jdk1point5();
            System.out.println(Thread.currentThread().getName());
        }).start();
        jdk1point5();
    }

    private static void traditional() {
        // 清单1：遍历数组的传统方式
        // 建立一个数组
        int[] integers = {1, 2, 3, 4};
        // 开始遍历
        for (int j = 0; j < integers.length; j++) {
            int i = integers[j];
            System.out.println(i);
        }

        //清单2：遍历Collection对象的传统方式
        // 建立一个Collection
        String[] strings = {"A", "B", "C", "D"};
        String[] strings1 = {"E", "F", "G", "H"};
        String[] strings2 = {"I", "J", "K", "L"};
        String[][] strings3 = {strings, strings1, strings2, strings1, strings};

        // 开始遍历
//
//        for (int i = 0; i < strings3.length; i++) {
//            for (int k = 0; i < strings3[i].length; k++) {
//                System.out.println(strings3[i][k]);
//            }
//        };

        Collection stringList = Arrays.asList(strings);
        /* 开始遍历 */
        for (Iterator itr = stringList.iterator(); itr.hasNext(); ) {
            Object str = itr.next();
            System.out.println(str);
        }

        for (String[] strings4 : strings3) {
            for (String s : strings4) {
                System.out.println(s);
            }
        }
    }

    private static void jdk1point5() {
        int[] integers = {1, 2, 3, 4};
        for (Integer i : integers) {
            System.out.println(i);/* 依次输出“1”、“2”、“3”、“4” */
        }
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            traditional();
            System.out.println(Thread.currentThread().getName());
        }
    }
}
