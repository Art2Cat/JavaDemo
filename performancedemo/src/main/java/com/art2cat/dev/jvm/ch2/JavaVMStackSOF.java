package com.art2cat.dev.jvm.ch2;

/**
 * VM args: -Xss160k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + javaVMStackSOF.stackLength);
            throw e;
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
