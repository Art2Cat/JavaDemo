package com.art2cat.dev.corejava;

import java.util.Scanner;

/**
 * Created by Rorschach
 * on 2017/3/30.
 */
public class RetirementTest {
    public static void main(String[] args) {
        retirement1();
    }

    private static void retirement() {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire? ");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance < goal) {
            balance += payment;
            double interest = balance * interestRate;
            balance += interest;
            years++;
        }

        System.out.println("You can retire in " + years + " years.");
    }

    private static void retirement1() {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        String input;

        do {
            balance += payment;
            double interest = balance * interestRate;
            balance += interest;

            years++;

            System.out.printf("After year %d, your balance is %,.2f%n", years, balance);

            System.out.println("Ready to retire?(Y/N)" );
            input = in.next();
            input = input.toUpperCase();
        } while (input.equals("N"));
    }

}
