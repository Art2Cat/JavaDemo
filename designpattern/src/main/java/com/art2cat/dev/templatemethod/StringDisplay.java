package com.art2cat.dev.templatemethod;

/**
 * com.art2cat.dev.templatemethod
 *
 * @author art2c
 * @date 5/21/2018
 */
public class StringDisplay extends AbstractDisplay {

    private int width;
    private String str;

    public StringDisplay(String str) {
        this.str = str;
        width = str.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + str + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
