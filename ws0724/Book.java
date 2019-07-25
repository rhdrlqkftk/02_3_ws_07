package com.ssafy;

public class Book {
	protected String isbn;
	protected String title;
	protected String author; 
	protected String publisher; 
	protected int price; 
	protected String decs;

	Book(String isbn, String title ,String author, String publisher, int price, String decs)
	{
		super();
		this.isbn = isbn; 
		this.decs = decs; 
		this.author =author; 
		this.price = price; 
		this.title = title;
		this.publisher = publisher; 
		
	}
	@Override
	public String toString() 
	{
		return isbn + "  |  " + title + "  |  " + author + "  |  " + publisher + "  |  " + price + "  |  " + decs ;
	} 
	

}
