package afternoon;

import java.util.List;

public interface IBookDao 
{
	List<Book> listBooks(); 
	List<Book> listLikeBooks(String kind, String what);
	Book findByBook(String isbn);
	
	void insertBook(Book b);
	void updateBook(Book b);
	void deleteBook(String isbn);
	int count();
	
}
//abstract : 상속 강요. 
//
