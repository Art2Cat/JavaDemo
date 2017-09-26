package com.art2cat.dev;

public class ThreadDemo {

    public static void main(String[] args) {
        boolean isDaemon = args.length != 0;

        Runnable runnable = () -> {
            Thread th = Thread.currentThread();
            while (true) {
                System.out.printf("%s is %s alive and in %s" + " state\n",
                        th.getName(),
                        th.isAlive() ? "" : "not",
                        th.getState());
            }
        };

        Thread thread = new Thread(runnable, "Thread");
        if (isDaemon)
            thread.setDaemon(true);
        System.out.printf("%s is %s alive and in %s '" + " state\n",
                thread.getName(),
                thread.isAlive() ? "" : "not",
                thread.getState());

        Thread thread1 = new Thread(runnable, "Thread1");
        if (isDaemon)
            thread1.setDaemon(true);
        System.out.printf("%s is %s alive and in %s '" + " state\n",
                thread1.getName(),
                thread1.isAlive() ? "" : "not",
                thread1.getState());

        thread.start();
        thread1.start();
    }
}
