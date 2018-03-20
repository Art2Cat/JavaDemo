package com.art2cat.dev.jnidemo;

class HelloWorld {
    
    private native void print();
    
    static {
        System.loadLibrary("HelloWorld");
    }
    
    public static void main(String[] args) {
        new HelloWorld().print();
    }

}