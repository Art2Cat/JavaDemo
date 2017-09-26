package com.art2cat.dev.corejava;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Rorschach
 * on 2017/3/30.
 */
public class BigIntegerTest {
    private static PrintStream ss = System.out;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("args length is zero");
            return;
        }
        if (args[0].equals("-h")) {
            System.out.println("Hello,");
        } else if (args[0].equals("-g")) {
            System.out.println("Goodbye,");
        }

        for (int i = 1; i < args.length; i++) {
            System.out.println(" " + args[i]);
        }
        System.out.println("!");
    }

    private static void lotteryOdds() {
        Scanner scanner = new Scanner(System.in);

        ss.print("How many numbers do you need to draw? ");
        int k = scanner.nextInt();

        ss.print("What is the highest number you can draw? ");
        int n = scanner.nextInt();

        BigInteger lotteryOdds = BigInteger.valueOf(1);

//        for (int i = 1; i <= k; i++) {
//            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
//            ss.println(lotteryOdds);
//        }

        int lotteryOdds1 = 1;
        for (int i = 1; i <= k; i++) {
            int j = (n - i + 1);
            if (j != 0) {
                String s = "" + j + "";
                if (s.contains("-")) {
                    s = s.replaceFirst("-", "");
                    ss.println("s = " + s);
                    j = Integer.valueOf(s.trim());
                    lotteryOdds1 = lotteryOdds1 * (j / i);
                } else {
                    lotteryOdds1 = lotteryOdds1 * (j / i);
                }

                String s1 = "" + lotteryOdds1 + "";
                if (s1.contains("-")) {
                    s1 = s1.replaceFirst("-", "");
                    lotteryOdds1 = Integer.valueOf(s1);
                }
                ss.println(lotteryOdds1);
            }
        }

        ss.println("Your odds are 1 in " + lotteryOdds1 + ". Good luck!");


    }
}
