package com.mjc813.server;

import com.mjc813.user.ChatUser;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@AllArgsConstructor
public class ServerChatSocket extends Thread {
    private ChatUser chatUser; // 비기본 생성자로 객체를 받아들인다.

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            while (true) {
                if (this.chatUser == null
                        || this.chatUser.getSocket() == null
                        || this.chatUser.getSocket().isClosed()) {
                    break;
                    // 객체 멤버변수의 값이 비정상이면 while을 빠져나가서 스레드 종료
                }
                // ChatUser의 소켓 입력 데이터를 String으로 화면에 출력한다.
                br = new BufferedReader(new InputStreamReader(this.chatUser.getSocket().getInputStream()));
                String msg = br.readLine();
                System.out.printf("%s : %s\n", this.chatUser.getName(), msg);
            }
        } catch (IOException e) {
            System.out.println(this.chatUser.getName() + "이 접속을 끊었습니다.");
        } finally {
            try {
                br.close();
            } catch (Exception e) {}
        }
    }
}
