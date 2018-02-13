package com.art2cat.dev.corejava;

import java.util.Scanner;

/**
 * Created by Rorschach on 2017/3/30.
 */
public class EnumTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a size: (small, medium, large, extra_large)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size = " + size);
        System.out.println("Abbreviation = " + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job!");
        }
    }

    enum Size {
        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        private String abbreviation;

        Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }
    }
}
