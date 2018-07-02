package com.art2cat.dev.decorator;

/**
 * com.art2cat.dev.decorator
 *
 * @author art2c
 * @date 5/31/2018
 */
public class StringDisplay extends AbstractDisplay {
    
    private String string;
    
    public StringDisplay(String string) {
        this.string = string;
    }
    
    @Override
    public int getColumns() {
        return string.getBytes().length;
    }
    
    @Override
    public int getRows() {
        return 1;
    }
    
    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return string;
        }
        return null;
    }
}
