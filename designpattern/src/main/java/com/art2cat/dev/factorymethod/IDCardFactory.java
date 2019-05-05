package com.art2cat.dev.factorymethod;

import java.util.ArrayList;
import java.util.List;

/**
 * com.art2cat.dev.factorymethod
 *
 * @author art2c
 * @date 5/22/2018
 */
public class IDCardFactory extends AbstractFactory implements IFactory {

    private List<String> owners = new ArrayList<>();

    @Override
    public void registerProduct(IProduct p) {
        owners.add(((IIDCard) p).getOwner());
    }

    @Override
    public IProduct createProduct(String owner) {
        return new IDCard(owner);
    }

    public List<String> getOwners() {
        return owners;
    }
}
