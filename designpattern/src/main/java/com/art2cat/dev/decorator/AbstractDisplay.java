package com.art2cat.dev.decorator;

/**
 * com.art2cat.dev.decorator
 *
 * @author art2c
 * @date 5/31/2018
 */
public abstract class AbstractDisplay {

    public abstract int getColumns();

    public abstract int getRows();

    public abstract String getRowText(int row);

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
