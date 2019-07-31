package teacher;
import java.util.List;

public interface IBookMgr 
{
	void add(Book b);
	List<Book> search();
	Book search(String isbn);
	List<Book> searchByTitle(String title);
	List<Book> searchOnlyBooks();
	List<Magazine> searchOnlyMaganzins();
	List<Magazine> searchMaganzins(int year);
	List<Book> searchByPublisher(String publiser);
	List<Book> searchByPrice(int price);
	int sum() ;
	double average();
}
