package com.art2cat.dev.multi_thread.chapterThree.joinTest;

/**
 * Created by Rorschach
 * on 11/07/2017.
 */
public class JoinTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread test = new Thread(()-> {
            try {
                int second = (int) (Math.random() * 10000);
                System.out.println(second);
                Thread.sleep(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "test");
        test.start();
        test.join(2000);
        System.out.println("print after test thread");

        ThreadB b = new ThreadB();
        Thread a = new Thread(() -> {
            synchronized (b) {
                try {
                    b.start();
                    // join() will release lock
                    b.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        a.start();
        Thread.sleep(1000);
        new Thread(b::bService).start();
    }
}
