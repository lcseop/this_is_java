package com.mjc813.onebyonefreechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerCommunicateSocket {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

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
}
