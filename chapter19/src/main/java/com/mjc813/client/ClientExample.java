package com.mjc813.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientExample {
    public void clientExample() {
        Socket socket = null;
        Scanner s = null;
        BufferedWriter bw = null;
        try {
            socket = new Socket("10.11.83.69", 50001);

            System.out.println("[클라이언트] 연결 성공");

            s = new Scanner(System.in);
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(s.nextLine());
        } catch (UnknownHostException e) {
            System.err.println("IP 표기 방법이 잘못 되었음: " + e);
        } catch (IOException e) {
            System.err.println("해당 포트의 서버에 연결 불가능: " + e);
        } finally {
            try {
                s.close();
            } catch (Exception e) {}
            try {
                bw.close();
            } catch (Exception e) {}
            try {
                socket.close();
            } catch (Exception e) {}
            System.out.println("[클라이언트] 연결 끊음");
        }
    }
}
