package com.art2cat.dev.corejava.network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {
    
    private static final String HOST = "https://art2cat.com";
    
    public static void main(String[] args) {
        try {
            URL url = new URL(HOST);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(10000);
            connection.connect();
            System.out.println(connection.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
