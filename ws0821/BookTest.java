package afternoon;

import java.util.List;

public class BookTest {
	public static void main(String[] args) {
		BookDaoImpl  dao = BookDaoImpl.getInstance(); 
		print(dao.listBooks()); 
		// TITLE, AUTHOR, PUBLISER, DESCRIPTION 
		String kind ="TITLE";
		print(dao.listLikeBooks(kind, "¿¹ºñ±º"));
		
		print(dao.findByBook("80001"));
		System.out.println(dao.count());
	}
	public static void print(List<Book> bs)
	{
		for(Book b : bs)
		{
			System.out.println(b);
		}
	}
	public static void print(Book bs)
	{
		System.out.println(bs);
	}
}
