package com.art2cat.dev.proxy;

/**
 * com.art2cat.dev.proxy
 *
 * @author art2c
 * @date 6/15/2018
 */
public interface IPrintable {

    String getPrinterName();

    void setPrinterName(String printerName);

    void print(String content);

}
