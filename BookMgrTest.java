package com.ssafy.edu.ws;

import java.util.List;

public class BookMgrTest {


	public static void main(String[] args) {
			
		BookMgrImpl bmgr=BookMgrImpl.getInstance();
		bmgr.open();
		bmgr.add(new Book("8001", "아현아놀자", 25000,20));
		bmgr.add(new Book("8002", "정원이의 하루", 50000,20));
		bmgr.add(new Book("8003", "치현이는 누구와 사귀는가?", 10000,30));
		bmgr.add(new Book("8004", "너희가 람다를 알아?", 30000,20));
		bmgr.add(new Magazine("8005", "희주는 람다를 안다", 4000,20, 9));
		bmgr.add(new Book("8006", "너희가 람다를 알아?", 30000,20));
		bmgr.add(new Book("8007", "너희가 람다를 알아?", 30000,20));

		print(bmgr.search());
		//bmgr.sortByTitleAsc();
		//print(bmgr.search());
		try {
			bmgr.buy("8004", 10);
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			bmgr.sell("80040", 10);
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (QuantityException e) {
			System.out.println(e.getMessage());
		}
		try {
			bmgr.sell("8004", 500);
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (QuantityException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(bmgr.getTotalAmount());
		bmgr.close();
	}
	
	public static  void print(List<Book> lt) {
		for (Book t: lt) {
			System.out.println(t);
		}
	}

}
