package com.mjc813.onebyonefreechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerCommunicateSocket extends Thread {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean active = true;

    public ServerCommunicateSocket(Socket socket) throws IOException {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
    }

    public void send(String msg) {
        try {
            this.dos.writeUTF(msg);
            this.dos.flush();
        } catch (IOException e) {}

    }

    public String read() {
        String str = "";
        try {
            str = this.dis.readUTF();
        } catch (IOException e) {}
        return str;
    }

    public void close() {
        active = false;
        try {
             this.dos.close();
        } catch (Exception e) {}
        try {
            this.dis.close();
        } catch (Exception e) {}
        try {
            this.socket.close();
        } catch (Exception e) {}
    }

    public boolean isActive() {
        return this.active;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = read();
                if (msg.isEmpty() || msg.equals(ServerApp.exitWord)) {
                    System.out.println("클라이언트로부터 접속이 종료되었습니다.");
                    break;
                }
                System.out.println(msg);
            }
        } catch (Exception e) {
        } finally {
            this.close();
            this.active = false;
        }

    }
}
