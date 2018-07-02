package com.art2cat.dev.proxy;

/**
 * com.art2cat.dev.proxy
 *
 * @author art2c
 * @date 6/15/2018
 */
public interface IPrintable {
    
    void setPrinterName(String printerName);
    
    String getPrinterName();
    
    void print(String content);
    
}
