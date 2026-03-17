package com.mjc813.multiclientfreechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

// 서버소켓 생성(ip대역 option, 포트번호 필수)
// 클라이언트 접속 기다리는 동작(블로킹)
// 클라이언트 접속이 되면 새로운 데이터소켓/클라이언트통신소켓 을 리턴한다.
// 새로운 통신 소켓과 클라이언트가 통신하도록 프로그래밍 해야 한다.
// 종료시에는 소켓과 자원을 모조리 해제 해야 한다.
public class ServerApp {
	private ServerSocket serverSocket;
	private ServerAcceptThread sat;

	private DataInputStream dis;
	private DataOutputStream dos;
	private boolean connected = false;
	public static final String exitWord = "!test@@@";

	public ServerApp() throws IOException {
		this.serverSocket = new ServerSocket(59997);
		sat = new ServerAcceptThread(serverSocket);
		// 포트번호로 서버소켓을 생성한다.
	}

	public void accept() throws IOException {
		this.sat.start();
		// 여러 클라이언트가 접속할 수 있도록 연결 기다리는 동작을 스레드로 처리
	}

	public void close() throws IOException {
		this.serverSocket.close();
	}

	public static void main(String[] args) {
		ServerApp sa = null;
		Scanner scanner = new Scanner(System.in);

		try {
			sa = new ServerApp();
			sa.accept();

			while (true) {
				String str = scanner.nextLine();
				sa.sat.sendAllClients(str);
			}
		} catch (Exception ex) {
			System.err.println(ex.toString());
		} finally {
			try {
				sa.close();
			} catch (Exception e) {}
		}

	}

}
