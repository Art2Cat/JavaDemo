package com.art2cat.dev.corejava.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoHandlerRunnable implements Runnable {
    
    private Socket socket;
    
    public EchoHandlerRunnable(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            
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
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
