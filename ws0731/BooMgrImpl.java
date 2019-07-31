package teacher;
import java.util.ArrayList;
import java.util.List;

public class BooMgrImpl implements teacher.IBookMgr {

	private ArrayList<Book> books =  new ArrayList<>();
	private static BooMgrImpl bookmgr = new BooMgrImpl();
	private BooMgrImpl() {
		books.clear();
	}
	public static BooMgrImpl getInstance()
	{
		return bookmgr;
	}
	private Book findByISBN(String isbn)
	{
		Book b = null;  
		for(Book bb : books)
		{
			if(bb.getIsbn().equals(isbn))
			{
				b =bb; 
			}
		}
		return b;
	}
	// findByISBN을 검색하는 방법.  
	
	@Override
	public void add(Book b) 
	{
		Book bb= findByISBN(b.getIsbn());
		if( bb== null)
		{
			books.add(b);
		}
	}// 이미 있는거는 등록 못하도록 만들었다. 

	@Override
	public List<Book> search() 
	{
		return books;
	}

	// 책이 있는지 검색한다. ㅉ
	@Override
	public Book search(String isbn) {
		return findByISBN(isbn);
	}

	// 제목 검색.  
	@Override
	public List<Book> searchByTitle(String title) {
		List<Book> nBooks = new ArrayList<>();
		for(Book bb :books )
		{
			if (bb.getTitle().contains(title)) {
				nBooks.add(bb);
			}
		}
		return nBooks;
	}

	@Override
	public List<Book> searchOnlyBooks() 
	{
		List<Book> nBooks = new ArrayList<>();
		for(Book bb :books )
		{
			if (!(bb instanceof Magazine)) 
			{
				nBooks.add(bb);
			}
		}
		return nBooks;
	}

	@Override
	public List<Magazine> searchOnlyMaganzins() {
		List<Magazine> nBooks = new ArrayList<>();
		for(Book bt :books )
		{
			if (bt instanceof Magazine) 
			{
				nBooks.add((Magazine)bt);
			}
		}
		return nBooks;
	}
	//올해 매거진 
	public List<Magazine> ThisyearMaganzins() 
	{
		List<Magazine> nBooks = searchOnlyMaganzins() ;
		List<Magazine> onlyB = new ArrayList<>();
		for(Magazine bt : nBooks )
		{
			if (bt.getYear() == 2019 ) 
			{
				onlyB.add((Magazine)bt);
			}
		}
		return onlyB;
	}
	@Override
	public List<Magazine> searchMaganzins(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByPublisher(String publiser) {
		List<Book> nBooks = new ArrayList<>();
		for(Book bb :books )
		{
			if (bb.getTitle().contains(publiser)) {
				nBooks.add(bb);
			}
		}
		return nBooks;
	}

	@Override
	public List<Book> searchByPrice(int price) {
		List<Book> nBooks = new ArrayList<>();
		for(Book bb :books )
		{	
			if(bb.getPrice() <= price)
			{
				nBooks.add(bb);
			}
		}
		return nBooks;
	}

	@Override
	public int sum() {
		int ss=0;
		for(Book bb :books )
		{
			ss +=  bb.getPrice();
		}
		return ss;
	}

	@Override
	public double average() {
		
		return sum()/books.size();
	}

}


// 이게 뭐야 근데
