package com.mjc813.server;

import com.mjc813.room.ChatRoom;
import com.mjc813.user.ChatUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ServerMain extends Thread implements ServerChatInterface {
    public static final String exitWord = "(3{}#quit~%#!#)(";
    public static final int PORT = 50813;
    private Map<Long, ChatRoom> chatRooms;
    private ServerSocket serverSocket;
    private Set<ServerChatSocket> lobby;
    private BufferedReader br;

    public ServerMain() {
//        this.chatRooms = new LinkedList<>();
        this.chatRooms = Collections.synchronizedMap(new HashMap<Long, ChatRoom>());
        this.lobby = Collections.synchronizedSet(new HashSet<ServerChatSocket>());
        try {
            this.serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                if (this.serverSocket.isClosed()) {
                    break;
                }
                Socket socket = this.serverSocket.accept();
                // 서버소켓이 클라이언트 연결을 받아들이면 새로운 통신소켓을 리턴받아야 한다.

                ChatUser cu = new ChatUser(socket.getInetAddress().getHostAddress(), socket);

//                ServerChatSocket scs = new ServerChatSocket(cu, this);
                ServerChatSocket scs = new ServerChatSocket(cu, this.lobby);
                scs.start();

                this.lobby.add(scs); // 접속한 사용자는 모두 로비에 추가했다.
                this.printLobby();
                // 접속한 클라이언트 사용자가 보내는 데이터를 스레드로 받을 준비를 해야 한다.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printLobby() {
        for (ServerChatSocket scs : this.lobby) {
            System.out.println("name: " + scs.getChatUser());
        }
    }

    @Override
    public void removeChatUser(ServerChatSocket scs) {
        this.lobby.remove(scs);
    }

    @Override
    public void sendAllClients(String msg) {
        for (ServerChatSocket scs : this.lobby) {
            scs.send(msg);
        }
    }

    public static void main(String[] args) {
        ServerMain sm = new ServerMain();
        sm.start();
    }
}