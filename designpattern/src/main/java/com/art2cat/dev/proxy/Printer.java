package com.art2cat.dev.proxy;

/**
 * com.art2cat.dev.proxy
 *
 * @author art2c
 * @date 6/15/2018
 */
public class Printer implements IPrintable {
    
    private String printerName;
    
    public Printer() {
    }
    
    public Printer(String printerName) {
        this.printerName = printerName;
        heavyJob("creating Printer instance.");
    }
    
    @Override
    public void setPrinterName(String printerName) {
       this.printerName = printerName;
    }
    
    @Override
    public String getPrinterName() {
        return printerName;
    }
    
    @Override
    public void print(String content) {
        System.out.println("=== " + printerName + " ===");
        System.out.println(content);
    }
    
    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("done.");
    }
}
