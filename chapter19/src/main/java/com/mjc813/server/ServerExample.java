package com.mjc813.server;

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
            try {
                serverSocket = new ServerSocket();
                serverSocket.bind(new InetSocketAddress(50001));
                System.out.println("[서버] 시작됨");

                while (true) {
                    System.out.println("\n[서버] 연결 요청을 기다림\n");
                    Socket socket = serverSocket.accept();

                    InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                    System.out.println("[서버] " + isa.getHostString() + "의 연결 요청을 수락함");

                    socket.close();
                    System.out.println("[서버] " + isa.getHostString() + "의 연결을 끊음");
                }
            } catch (IOException e) {
                System.err.println("[서버] " + e.getMessage());
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
