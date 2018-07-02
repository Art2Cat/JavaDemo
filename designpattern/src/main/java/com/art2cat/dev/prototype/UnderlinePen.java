package com.art2cat.dev.prototype;

import com.art2cat.dev.prototype.framework.IProduct;

/**
 * com.art2cat.dev.prototype
 *
 * @author art2c
 * @date 5/23/2018
 */
public class UnderlinePen implements IProduct {
    
    private char ulChar;
    
    public UnderlinePen(char ulChar) {
        this.ulChar = ulChar;
    }
    
    @Override
    public void use(String str) {
        System.out.println("\"" + str + "\"");
        System.out.print(" ");
        for (int i = 0; i < str.getBytes().length; i++) {
            System.out.print(ulChar);
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
