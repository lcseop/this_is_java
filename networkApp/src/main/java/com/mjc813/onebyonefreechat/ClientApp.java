package com.mjc813.onebyonefreechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public ClientApp() throws IOException {
		this.socket = new Socket(); // 클라이언트의 통신용 소켓 생성
	}

	public Socket getSocket() {
		return this.socket;
	}

	public void connect() throws IOException {
//		this.socket.bind(new InetSocketAddress("localhost", 59999)); // ip 와 포트 정보를 bind 하고 접속 시도한다.
		this.socket.connect(new InetSocketAddress("localhost", 59990));
		// 해당 ip 와 포트로 접속을 시도한다.
	}

	public void close() throws IOException {
		this.socket.close();
		// 클라이언트 통신 소켓을 닫는다.
	}

	public String read() {
		String str = null;
		try {
			dis = new DataInputStream(this.socket.getInputStream());
			str = dis.readUTF();
		} catch (IOException e) {
			System.err.println("데이터 입력 받을 수 없습니다.");
		}
		return str;
	}

	public void send(String msg) {
		try {
			dos = new DataOutputStream(this.socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		} catch (Exception ex) {
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				String msg = this.read();
				if (msg.equals(ServerApp.exitWord)) {
					System.out.println("서버로부터 접속이 종료되었습니다.");
					this.close();
				}
				System.out.println("SERVER: " + msg);
			}
		} catch (Exception e) {
            try {
                this.close();
            } catch (IOException ex) {}
        }

	}

	public static void main(String[] args) {
		ClientApp ca = null;
		try {
			ca = new ClientApp();
			Scanner s = new Scanner(System.in);
			ca.connect();

			ca.start();
			while (true) {
				String msg = s.nextLine();
				if (msg.equals("quit")) {
					ca.send(ServerApp.exitWord);
					break;
				}
				ca.send(ca.getSocket().getInetAddress().getHostAddress() + ": " + msg);

			}
			s.close();

		} catch (Exception ex) {
			System.err.println(ex.toString());
		} finally {
			try {
				ca.close();
			} catch (Exception e) {}
			System.exit(-999);
		}
	}
}
