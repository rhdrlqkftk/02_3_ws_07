package com.ssafy;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		System.out.println("*************************도서 목록*************************");	
		Book book1 = new Book("21424", "java pro", "김하나", "jane.kr", 15000 ,"기본 문법");
		Book book2 = new Book("35355", "분석 설계", "소나무", "jane.kr",30000 ,"SW 모델링");		
		Book book3 = new Magazine("44444", "Java World", "편집부", "java.com", 7000, "첫걸음", 2018, 7); 
		
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(book3.toString());
	}
}
