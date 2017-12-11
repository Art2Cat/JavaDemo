package com.art2cat.dev.corejava.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadEchoServer {
    public static void main(String[] args) {
        // telnet localhost 8964
        // establish server socket
        try {
            int number = 1;
            ServerSocket serverSocket = new ServerSocket(8964);
            while (true) {
                Socket incoming = serverSocket.accept();
                System.out.println("Spawning " + number);
                Thread thread = new Thread(new EchoHandlerRunnable(incoming));
                thread.start();
                number++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
