package com.mjc813.client;

import java.io.IOException;
import java.net.*;

public class ClientExample {
    public void clientExample() {
        try {
            Socket socket = new Socket("10.11.83.68", 50001);

            System.out.println("[클라이언트] 연결 성공");

            socket.close();
            System.out.println("[클라이언트] 연결 끊음");
        } catch (UnknownHostException e) {
            System.err.println("IP 표기 방법이 잘못 되었음: " + e);
        } catch (IOException e) {
            System.err.println("해당 포트의 서버에 연결 불가능: " + e);
        }
    }
}
