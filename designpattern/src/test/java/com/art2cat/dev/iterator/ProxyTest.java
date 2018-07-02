package com.art2cat.dev.iterator;

import com.art2cat.dev.proxy.IPrintable;
import com.art2cat.dev.proxy.PrinterProxy;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 6/15/2018
 */
public class ProxyTest {
    
    @Test
    public void test() {
        IPrintable proxy = new PrinterProxy("Alice");
        System.out.println("printer name is : " + proxy.getPrinterName());
        proxy.setPrinterName("Bob");
        System.out.println("printer name is : " + proxy.getPrinterName());
        proxy.print("Hello, world.");
    }
    
}
