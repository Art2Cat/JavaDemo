package com.art2cat.dev.decorator;

/**
 * com.art2cat.dev.decorator
 *
 * @author art2c
 * @date 5/31/2018
 */
public class SideBorder extends AbstractBorder {
    
    private char borderChar;
    
    public SideBorder(AbstractDisplay display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }
    
    @Override
    public int getColumns() {
        return display.getColumns() +2;
    }
    
    @Override
    public int getRows() {
        return display.getRows();
    }
    
    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
