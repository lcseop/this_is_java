package com.mjc813.client;

import com.mjc813.server.ServerMain;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static com.mjc813.server.ServerMain.exitWord;

public class ClientMain2 extends Thread {
    // ChatUser는 서버 접속 후에 닉네임을 전송해야 한다.
    // InputStream이 블로킹 상태이므로 스레드가 필요하다.
    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;

    public ClientMain2(String ip) {
        try {
            this.socket = new Socket(ip, ServerMain.PORT);
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            this.bw.close();
        } catch (Exception e) {}
        try {
            this.br.close();
        } catch (Exception e) {}
        try {
            this.socket.close();
        } catch (Exception e) {}
    }

    public void send(String msg) {
        try {
            this.bw.write(msg);
            this.bw.newLine();
            this.bw.flush();
        } catch (Exception e) {
            this.close();
        }
    }

    public void doChat() {
        Scanner s = new Scanner(System.in);
        try {
            while (true) {
                String msg = s.nextLine();
                if (msg.equals("quit")) {
                    this.send(exitWord);
                    break;
                }
                this.send(msg);
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
            this.close();
            System.exit(-999);
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                String msg = this.br.readLine();
                System.out.println("Server: " + msg);
            }
        } catch (Exception e) {
            System.out.println("접속이 끊겼습니다.");
        } finally {
            this.close();
            System.exit(-999);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("서버 IP를 인자로 넣어주세요.");
            return;
        }
        try {
            ClientMain2 cm = new ClientMain2(args[0]);
            cm.start();
            cm.doChat();
        } catch (Throwable e) {
            System.out.println(e.toString());
        }

    }
}
