package com.ssafy.edu.ws;

import java.io.Serializable;

public class Magazine extends Book implements Serializable {
	private int month;

	public Magazine() {
		super();
	}

	public Magazine(String isbn, String title, 
			int price, int quantity, int month) {
		super(isbn, title, price, quantity);
		this.month=month;
	}

	@Override
	public String toString() {
		return  isbn + "| " + title + "| " + price 
				+ "| " + quantity+"| " + month ;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	
	
}
