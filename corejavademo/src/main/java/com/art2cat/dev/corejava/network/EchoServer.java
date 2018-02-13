package com.art2cat.dev.corejava.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    
    public static void main(String[] args) {
        // telnet localhost 8964
        // establish server socket
        try (ServerSocket serverSocket = new ServerSocket(8964)) {
            // wait for client connection
            try (Socket incoming = serverSocket.accept()) {
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                try (Scanner scanner = new Scanner(inputStream)) {
                    PrintWriter out = new PrintWriter(outputStream, true);
                    out.println("Hello! Enter BYE to exit.");
                    
                    boolean done = false;
                    while (!done && scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        out.println("Echo: " + line);
                        if ("bye".equals(line.trim().toLowerCase())) {
                            done = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
