package com.mjc813.multiclientfreechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerCommunicateSocket extends Thread {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private ServerNetworkInterface sni;
    private boolean active = true;

    public ServerCommunicateSocket(Socket socket, ServerNetworkInterface sni) throws IOException {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
        this.sni = sni;
    }

    public void send(String msg) throws IOException {
        this.dos.writeUTF(msg);
        this.dos.flush();

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
                this.sni.sendAllClients(msg);
//                System.out.println(msg);
            }
        } catch (Exception e) {
        }
        this.active = false;
        this.sni.deleteClient(this);

    }
}
