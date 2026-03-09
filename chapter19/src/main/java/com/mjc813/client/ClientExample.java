package com.mjc813.client;

import java.net.*;

public class ClientExample {
    public void clientExample() {
        try {
            InetAddress local = InetAddress.getLocalHost();
            Socket socket = new Socket(local.getHostAddress(), 50001);

            System.out.println("[클라이언트] 연결 성공");

            socket.close();
            System.out.println("[클라이언트] 연결 끊음");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
