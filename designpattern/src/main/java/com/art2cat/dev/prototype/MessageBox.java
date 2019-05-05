package com.art2cat.dev.prototype;

import com.art2cat.dev.prototype.framework.IProduct;

/**
 * com.art2cat.dev.prototype.framework
 *
 * @author art2c
 * @date 5/23/2018
 */
public class MessageBox implements IProduct {

    private char decoChar;

    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    @Override
    public void use(String str) {
        print(str);
        System.out.print("");
        System.out.println(decoChar + " " + str + " " + decoChar);
        print(str);
    }

    private void print(String str) {
        int length = str.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decoChar);
        }
        System.out.println("");
    }

    @Override
    public IProduct createClone() {
        IProduct product = null;
        try {
            product = (IProduct) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
