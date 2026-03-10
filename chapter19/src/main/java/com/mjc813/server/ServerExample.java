package com.mjc813.server;

import java.io.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
    private static ServerSocket serverSocket = null;

    public void serverExample() {
        System.out.println("----------------------------------------------");
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("----------------------------------------------");

        startServer();

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String key = scanner.nextLine();
            if (key.toLowerCase().equals("q")) {
                break;
            }
        }
        scanner.close();

        stopServer();
    }

    public void startServer() {
        Thread thread = new Thread(() -> {
            Socket socket = null;
            BufferedReader breader = null;
            InetSocketAddress isa = null;
            try {
                serverSocket = new ServerSocket(50001);
            } catch (Exception e) {}
            System.out.println("[서버] 시작됨");
            while (true) {
                try {
                    System.out.println("\n[서버] 연결 요청을 기다림\n");
                    socket = serverSocket.accept();
                    isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                    System.out.println("[서버] " + isa.getHostString() + "의 연결 요청을 수락함");
                    breader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg = breader.readLine();
                    System.out.println(msg);
                    socket.close();
                    System.out.println("[서버] " + isa.getHostString() + "의 연결을 끊음");
                } catch (IOException e) {
                    System.err.println("[서버] " + e.getMessage());
                } finally {
                    try {
                        breader.close();
                    } catch (Exception e) {}
                    try {
                        socket.close();
                    } catch (Exception e) {}
                    System.out.println("[서버] " + isa.getHostString() + "의 연결을 끊음");
                }

            }

        });

        thread.start();
    }

    public void stopServer() {
        try {
            serverSocket.close();
            System.out.println("[서버] 종료됨 ");
        } catch (IOException e) {}
    }
}
