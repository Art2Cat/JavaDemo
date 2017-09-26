package com.art2cat.dev.multi_thread.chapterThree.twoThreadTransData;


import java.util.Objects;

/**
 * Created by Rorschach
 * on 07/07/2017.
 */
public class Test {
    public static void main(String[] args) {
        MyList list = new MyList();

        Thread thread = new Thread(() -> {

            try {
                synchronized (list) {
                    for (int i = 0; i < 10; i++) {
                        list.add();
                        if (i == 5) {
                            list.notify();
                            System.out.println("线程A 已发出通知！");
                        }
                        System.out.println("线程A状态： " + Thread.currentThread().getState());
                        System.out.println(Thread.currentThread().getName() + " 添加了" + (i + 1) + "个元素");
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "A");


        Thread thread1 = new Thread(() -> {
            try {
                synchronized (list) {
                    if (list.size() != 5) {
                        System.out.println("等待开始： " + System.currentTimeMillis());
                        list.wait();
                        System.out.println("等待结束： " + System.currentTimeMillis());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B");


        thread1.start();
        thread.start();

        boolean flag = true;
        while (true) {
            System.out.println("线程B状态： " + thread1.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Objects.equals("TERMINATED", thread1.getState().toString())) {
                break;
            }
            if ("BLOCKED".equals(thread1.getState().toString()) && flag) {
                System.out.println("线程B被唤醒了~");
                flag = false;
            }
        }
    }
}
