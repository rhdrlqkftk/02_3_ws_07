package com.ssafy.edu.ws;

import java.util.List;

public interface IBookMgr {
	void add(Book b);
	List<Book> search();
	void sell(String isbn, int quantity) throws
	  QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	int getTotalAmount();
	List<Book> searchByPrice(int price);
	void sortByTitleAsc();
	void sortByTitleDesc();
	void sortByQuantity();
	void open();
	void close();
	Book searchByIsbn(String isbn);
	List<Book> searchByTitle(String title);
}
