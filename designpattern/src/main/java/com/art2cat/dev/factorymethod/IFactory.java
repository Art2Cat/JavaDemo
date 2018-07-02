package com.art2cat.dev.factorymethod;

/**
 * com.art2cat.dev.factorymethod
 *
 * @author art2c
 * @date 5/22/2018
 */
public interface IFactory {
    
    
    IProduct createProduct(String owner);
    
    void registerProduct(IProduct product);
    
    default IProduct create(String owner) {
        IProduct product = createProduct(owner);
        registerProduct(product);
        return product;
    }
}
