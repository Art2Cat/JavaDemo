package com.art2cat.dev.corejava;

import java.io.Console;
import java.util.Scanner;

/**
 * Created by Rorschach
 * on 2017/3/30.
 */
public class InputTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("What is your name?");
        String name = in.nextLine();

        System.out.print("How old are you?");
        int age = in.nextInt();

        System.out.println("Hello, " + name +". Next year you will be " + (age+1));

    }

    public static void inputPassword() {
        Console console = System.console();
        String username = console.readLine("User name: ");
        char[] password = console.readPassword("User name: ");
    }
}
