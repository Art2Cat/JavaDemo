package com.art2cat.dev.factorymethod;

/**
 * com.art2cat.dev.factorymethod
 *
 * @author art2c
 * @date 5/22/2018
 */
public class IDCard implements IIDCard {
    
    private String owner;
    
    IDCard(String owner) {
        System.out.println(" make " + owner + "'s ID Card");
        this.owner = owner;
    }
    
    @Override
    public void use() {
        System.out.println(" use " + owner + "'s ID Card.");
    }
    
    @Override
    public String getOwner() {
        return owner;
    }
}
