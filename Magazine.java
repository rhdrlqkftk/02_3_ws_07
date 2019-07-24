package com.ssafy;

public class Magazine extends Book{
	protected int year;
	protected int month;
	
	public Magazine(String isbn, String title ,String author, String publisher, int price, String decs, int year, int month) 
	{
		super(isbn, title ,author, publisher,price,decs); 
		this.year = year;
		this.month = month; 
	}
	
	@Override
	public String toString() {
		return isbn + "  |  " + title + "  |  " + author + "  |  " + publisher + "  |  " + price + "  |  " + decs + "  |  " + year + "."+ month;
	}

	
}
