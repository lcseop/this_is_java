package com.mjc813.client;

import com.mjc813.server.ServerMain;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain extends Thread {
    // ChatUser는 서버 접속 후에 닉네임을 전송해야 한다.
    // InputStream이 블로킹 상태이므로 스레드가 필요하다.
    private Socket socket;
    public ClientMain(String ip) {
        try {
            this.socket = new Socket(ip, ServerMain.PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doChat() {
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = null;
        try {
            while (true) {
                String msg = s.nextLine();
                if (msg.equals("quit")) {
                    break;
                }
                bw = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
                bw.write(msg);
                bw.flush();
            }
        } catch (Exception e) {
            System.out.println("접속이 끊겼습니다.");
        } finally {
            try {
                bw.close();
            } catch (Exception e) {}
            try {
                s.close();
            } catch (Exception e) {}
        }
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            while(true) {
                br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                String msg = br.readLine();
                System.out.println("Server: " + msg);
            }
        } catch (Exception e) {
            System.out.println("접속이 끊겼습니다.");
        } finally {
            try {
                br.close();
            } catch (Exception e) {}
            try {
                this.socket.close();
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("서버 IP를 인자로 넣어주세요.");
            return;
        }
        try {
            ClientMain cm = new ClientMain(args[0]);
            cm.start();
            cm.doChat();
        } catch (Throwable e) {
            System.out.println(e.toString());
        }

    }
}
