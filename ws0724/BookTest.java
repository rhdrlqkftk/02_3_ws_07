package com.ssafy;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		System.out.println("*************************���� ���*************************");	
		Book book1 = new Book("21424", "java pro", "���ϳ�", "jane.kr", 15000 ,"�⺻ ����");
		Book book2 = new Book("35355", "�м� ����", "�ҳ���", "jane.kr",30000 ,"SW �𵨸�");		
		Book book3 = new Magazine("44444", "Java World", "������", "java.com", 7000, "ù����", 2018, 7); 
		
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(book3.toString());
	}
}
