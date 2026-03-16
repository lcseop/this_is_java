package com.mjc813.onebyonefreechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 서버소켓 생성(ip대역 option, 포트번호 필수)
// 클라이언트 접속 기다리는 동작(블로킹)
// 클라이언트 접속이 되면 새로운 데이터소켓/클라이언트통신소켓 을 리턴한다.
// 새로운 통신 소켓과 클라이언트가 통신하도록 프로그래밍 해야 한다.
// 종료시에는 소켓과 자원을 모조리 해제 해야 한다.
public class ServerApp {
	private ServerSocket serverSocket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public ServerApp() throws IOException {
		this.serverSocket = new ServerSocket(59990);
		// 포트번호로 서버소켓을 생성한다.
	}

	public Socket accept() throws IOException {
		return this.serverSocket.accept();
		// 생성된 소켓으로 서버는 클라이언트 연결을 기다린다.
		// 클라이언트 연결이 되면 Socket 객체를 리턴한다.
	}

	public void close() throws IOException {
		this.serverSocket.close();
	}

	public static void main(String[] args) {
		ServerApp sa = null;
		Scanner scanner = null;
		ServerCommunicateSocket scs = null;
		try {
			scanner = new Scanner(System.in);
			sa = new ServerApp();
			Socket socket = sa.accept();
			scs = new ServerCommunicateSocket(socket);

			while (true) {
				String msg = scs.read();
				System.out.println(msg);

				scs.send(scanner.nextLine());
            }
		} catch (Exception e) {
			System.err.println(e.toString());
		} finally {
			try {
				scs.close();
			} catch (Exception e) {}
			try {
				sa.close();
			} catch (Exception e) {}
		}
	}
}
