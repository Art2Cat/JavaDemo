package com.art2cat.dev.jvm.ch7;

public class ClinitClass {

    public static void main(String[] args) {
        System.out.println(Sub.B); // output 2
    }

    static class Parent {

        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {

        public static int B = A;
    }
}
