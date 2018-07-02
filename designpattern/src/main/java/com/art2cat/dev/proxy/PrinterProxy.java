package com.art2cat.dev.proxy;

/**
 * com.art2cat.dev.proxy
 *
 * @author art2c
 * @date 6/15/2018
 */
public class PrinterProxy implements IPrintable {
    
    private String printerName;
    private Printer real;
    
    public PrinterProxy() {
    }
    
    public PrinterProxy(String printerName) {
        this.printerName = printerName;
    }
    
    @Override
    public String getPrinterName() {
        return printerName;
    }
    
    @Override
    public synchronized void setPrinterName(String printerName) {
        this.printerName = printerName;
    }
    
    @Override
    public void print(String content) {
        realize();
        real.print(content);
    }
    
    private synchronized void realize() {
        if (real == null) {
            real = new Printer(printerName);
        }
    }
}
