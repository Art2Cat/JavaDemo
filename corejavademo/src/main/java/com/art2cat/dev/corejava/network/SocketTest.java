package com.art2cat.dev.corejava.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    
    public static final String HOST = "time-A.timefreq.bldrdoc.gov";
    
    public static void main(String[] args) {
        socket();
        socketWithTimeOut();
    }
    
    private static void socket() {
        try (Socket s = new Socket(HOST, 13)) {
            // time out after 10 seconds
            s.setSoTimeout(10000);
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void socketWithTimeOut() {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(HOST, 13), 10000);
            if (socket.isConnected()) {
                System.out.println("socket is connected!");
                InputStream inputStream = socket.getInputStream();
                Scanner in = new Scanner(inputStream);
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
