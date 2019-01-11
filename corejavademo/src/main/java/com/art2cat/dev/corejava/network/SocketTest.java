package com.art2cat.dev.corejava.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {

    static final String HOST = "time-A.timefreq.bldrdoc.gov";

    public static void main(String[] args) {
        socket();
        socketWithTimeOut();
    }

    private static void socket() {
        try (Socket s = new Socket(HOST, 13); Scanner in = new Scanner(s.getInputStream())) {
            // time out after 10 seconds
            s.setSoTimeout(10000);
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
                Scanner in = new Scanner(socket.getInputStream());
                System.out.println("socket is connected!");
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);
                }
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
