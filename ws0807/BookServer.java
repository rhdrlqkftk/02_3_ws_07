package com.ssafy.edu.ws;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BookServer {

	String ip="127.0.0.1";
	int port=9987;
	
	public static void main(String[] args) {
		BookServer server=new BookServer();
		server.go();
	}
	ServerSocket ss;
	ObjectInputStream ois;
	
	public void go() {
		try {
			ss=new ServerSocket(port);
			ss.setReuseAddress(true);
			System.out.println("1. Serer Ready ~~~");
			while(true) {
				Socket s=ss.accept();
				ois=new ObjectInputStream(s.getInputStream());
				System.out.println("2. "+s.getInetAddress()+"에 붙음");
				int size=ois.readInt();
				for (int i = 0; i < size; i++) {
					Book bb=(Book)ois.readObject();
					System.out.println(bb);
				}
			}
			
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}finally {
			if(ois!=null) {try {
				ois.close();
			} catch (IOException e) {
				System.out.println(e);
			}}
			if(ss!=null) {try {
				ss.close();
			} catch (IOException e) {
				System.out.println(e);
			}}
		}
		
	}
	
	
	
}
