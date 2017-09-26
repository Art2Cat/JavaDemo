package com.art2cat.dev.thread;

public class Stage extends Thread {

    public void run() {

        System.out.println("welcome to the cinema!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("film start!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("begin...");

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();


        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "Sui");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "Revolt");

        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("����˫����ս��������·ɱ���˸���ҧ��");

        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("Hero");

        System.out.println("Hero will stop the war!fight for peace of the world!");

        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mrCheng.start();

        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Hero stop the war!");
        System.out.println("thank you for watch");

    }

    public static void main(String[] args) {
        new Stage().start();

        for (int i = 0; i < 10; i++) {
            System.out.println("i++ = " + i);
        }
        for (int i = 0; i < 10; ++i) {
            System.out.println("++i = " + i);
        }
    }

}
