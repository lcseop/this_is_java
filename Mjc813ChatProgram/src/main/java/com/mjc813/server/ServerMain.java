package com.mjc813.server;

import com.mjc813.room.ChatRoom;
import com.mjc813.user.ChatUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ServerMain extends Thread {
    public static final int PORT = 50813;
    private Map<Long, ChatRoom> chatRooms;
    private ServerSocket serverSocket;
    private Set<ChatUser> lobby;

    public ServerMain() {
//        this.chatRooms = new LinkedList<>();
        this.chatRooms = Collections.synchronizedMap(new HashMap<Long, ChatRoom>());
        this.lobby = Collections.synchronizedSet(new HashSet<ChatUser>());
        try {
            this.serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while(true) {
            BufferedReader br = null;
            try {
                if (this.serverSocket.isClosed()) {
                    break;
                }
                Socket socket = this.serverSocket.accept();
                // 서버소켓이 클라이언트 연결을 받아들이면 새로운 통신소켓을 리턴받아야 한다.

                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String name = br.readLine();
                // 클라이언트는 연결 후에 대화명을 서버로 전송해야지 서버는 InputStream으로 읽을 수 있다.
                ChatUser cu = new ChatUser(name, socket);

                this.lobby.add(cu); // 접속한 사용자는 모두 로비에 추가했다.

                try {
                    br.close();
                } catch (Exception e) {}
                ServerChatSocket scs = new ServerChatSocket(cu);
                scs.start();
                // 접속한 클라이언트 사용자가 보내는 데이터를 스레드로 받을 준비를 해야 한다.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ServerMain sm = new ServerMain();
        sm.start();
    }
}