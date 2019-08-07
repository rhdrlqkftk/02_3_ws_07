package com.ssafy.edu.ws;

import java.util.List;

public interface IBookMgr {
	void add(Book b);
	List<Book> search();
	Book searchByIsbn(String isbn);
	void sell(String isbn, int quantity) throws
	  QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	int getTotalAmount();
	List<Book> searchByPrice(int price);
	List<Book> searchByTitle(String title);
	void sortByTitleAsc();
	void sortByTitleDesc();
	void sortByQuantity();
	void open();
	void close();
	
	void send();
	
	
}
