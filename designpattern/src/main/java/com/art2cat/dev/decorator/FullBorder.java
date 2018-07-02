package com.art2cat.dev.decorator;

/**
 * com.art2cat.dev.decorator
 *
 * @author art2c
 * @date 5/31/2018
 */
public class FullBorder extends AbstractBorder {
    
    public FullBorder(AbstractDisplay display) {
        super(display);
    }
    
    @Override
    public int getColumns() {
        return display.getColumns() + 2;
    }
    
    @Override
    public int getRows() {
        return display.getRows() + 2;
    }
    
    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        }
        return "|" + display.getRowText(row - 1) + "|";
    }
    
    private String makeLine(char ch, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
