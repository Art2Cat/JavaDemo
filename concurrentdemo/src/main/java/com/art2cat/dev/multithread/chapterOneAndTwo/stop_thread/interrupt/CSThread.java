package com.art2cat.dev.multithread.chapterOneAndTwo.stop_thread.interrupt;

/**
 * Created by Rorschach on 6/29/2017.
 */
public class CSThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            printLoop();
            System.out
                .println("if I was print, first loop end, second loop continue performance, " +
                    "so thread will not stop");
            for (int i = 10; i >= 0; i--) {
                System.out.println("thread end count down: " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("throw interruptedException to end this thread" +
                "and under this line code will never execute");
        }

    }

    private synchronized void printLoop() throws InterruptedException {
        int count = 500000;
        for (int i = 0; i < count; i++) {
            if (Thread.interrupted()) {
//                Thread.sleep(3000);
                System.out.println("已经停止,准备退出");
                throw new InterruptedException();
            }
            if (i == 100000 || i == 150000) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + ": i = " + (i + 1));
        }
    }
}
