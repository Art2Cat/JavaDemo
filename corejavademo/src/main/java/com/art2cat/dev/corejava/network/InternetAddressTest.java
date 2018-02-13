package com.art2cat.dev.corejava.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InternetAddressTest {

    public static void main(String[] args) {
        InetAddress[] addresses = new InetAddress[0];
        
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Localhost: " + localHost);
            addresses = InetAddress.getAllByName(SocketTest.HOST);
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Arrays.asList(addresses).forEach(System.out::println);
    }
}
