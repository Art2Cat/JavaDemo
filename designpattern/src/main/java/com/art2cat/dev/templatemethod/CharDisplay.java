package com.art2cat.dev.templatemethod;

/**
 * com.art2cat.dev.templatemethod
 *
 * @author art2c
 * @date 5/21/2018
 */
public class CharDisplay extends AbstractDisplay {

    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
