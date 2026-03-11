package com.mjc813.server;

import com.mjc813.user.ChatUser;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.Set;

public class ServerChatSocket extends Thread {
    private final ChatUser chatUser; // 비기본 생성자로 객체를 받아들인다.
    private BufferedReader br;
    private BufferedWriter bw;
    private ServerChatInterface sci;
    private Set<ServerChatSocket> users;

    public ChatUser getChatUser() {
        return this.chatUser;
    }

    public ServerChatSocket(ChatUser cu, ServerChatInterface sci) throws IOException {
        this.chatUser = cu;
        this.br = new BufferedReader(new InputStreamReader(cu.getSocket().getInputStream()));
        this.bw = new BufferedWriter(new OutputStreamWriter(cu.getSocket().getOutputStream()));
        this.sci = sci;
    }

    public ServerChatSocket(ChatUser cu, Set<ServerChatSocket> users) throws IOException {
        this.chatUser = cu;
        this.br = new BufferedReader(new InputStreamReader(cu.getSocket().getInputStream()));
        this.bw = new BufferedWriter(new OutputStreamWriter(cu.getSocket().getOutputStream()));
        this.users = users;
    }

    public void close() {
        try {
            this.bw.close();
        } catch (Exception e) {}
        try {
            this.br.close();
        } catch (Exception e) {}
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (this.chatUser == null
                        || this.br == null
                        || this.bw == null
                        || this.chatUser.getSocket() == null
                        || this.chatUser.getSocket().isClosed()) {
                    break;
                    // 객체 멤버변수의 값이 비정상이면 while을 빠져나가서 스레드 종료
                }
                // ChatUser의 소켓 입력 데이터를 String으로 화면에 출력한다.
                String msg = this.br.readLine();
                String data;
                if (ServerMain.exitWord.equals(msg)) {
                    data = this.chatUser.getName() + "클라이언트가 종료 했습니다.";
                    System.out.println(data);
                    this.sendAllMessage(data);
                    break;
                }
                data = String.format("%s : %s\n", this.chatUser.getName(), msg);
                System.out.printf(data);
                this.sendAllMessage(data);
            }
        } catch (IOException e) {
            String data = this.chatUser.getName() + " 클라이언트 접속을 끊었습니다.";
            System.out.println(data);
            this.sendAllMessage(data);
        } finally {
            this.close();
//            this.sci.removeChatUser(this.chatUser);
            this.users.remove(this.chatUser);
        }
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

    public void sendAllMessage(String msg) {
        for (ServerChatSocket scs : this.users) {
            if (!scs.equals(this)) {
                scs.send(msg);
            }
        }
    }
}
