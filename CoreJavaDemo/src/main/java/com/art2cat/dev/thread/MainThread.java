package com.art2cat.dev.thread;

/**
 * Created by Rorschach
 * on 4/1/2017.
 */
public class MainThread {
    public static void main(String[] args) {
        Thread aA = new CustomThread("Coumpter 1");
        Thread aB = new CustomThread("Coumpter 2");
        Thread aC = new CustomThread("Coumpter 3");
        Thread aD = new CustomThread("Coumpter 4");
        Thread aE = new CustomThread("Coumpter 5");

        new Thread(aA).start();
        new Thread(aB).start();
        new Thread(aC).start();
        new Thread(aD).start();
        new Thread(aE).start();

//        aA.start();
//        aB.start();
//        aC.start();
//        aD.start();
//        aE.start();

        new Thread(()-> {
            System.out.println("fuck your wife!");
        }).start();

        if (aA.isAlive()) {
            try {
                aA.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
