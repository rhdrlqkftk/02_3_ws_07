package WS;

public class BookManager {

	private Book [] books;  
	private int index =0;  
	public BookManager() 
	{
		books = new Book[100]; // 객체 생성된거아니다. 자리 확보만 된거다.!
	}
	//책 추가 
	public void addBook( Book book )
	{
		if(index >= 0 && index <books.length)
		{
			books[index++]= book;
		}
		else
		{	
			index =0;
		}
	}
	// 전체 검색. 
	public void search()
	{
		for (int i = 0; i < index; i++) {
			System.out.println(books[i]);
		}
	}	
	
	// isbn으로 검색 
	public void search(String isbn)
	{
		for (int i = 0; i < index; i++) 
		{
			if(books[i].isbn.equals(isbn))
			{
				System.out.println(books[i]);				
			}
		}
	}	
	// book만 검색. 
	public void searchOnlyBook( )
	{
		for (int i = 0; i < index; i++) {
			if (!(books[i] instanceof Magazine)) {
				System.out.println(books[i]);
			}
		}
	}
	// title로 검색. 
	public void searchByTitle( String title)
	{
		for (int i = 0; i < index; i++) 
		{
			if(books[i].getTitle().contains(title))
			{
				System.out.println(books[i]);
			}
		}
	}

	// 가격으록검색
		public void search(int price) {
			for (int i = 0; i < index; i++) {
				if (books[i].price< price) {
					System.out.println(books[i]);
				}
			}
		}

	// 출판사 검색 
	public void searchPublisher( String title)
	{
		for (int i = 0; i < index; i++) 
		{
			if(books[i].equals(title))
			{
				System.out.println(books[i]);
			}
		}
	}
	// Magazine만 검색 
	public void searchOnlyMagazine() {
		for (int i = 0; i < index; i++) {
			if (books[i] instanceof Magazine) {
				System.out.println(books[i]);
			}
		}

	}
	// 추가 하기 .
	public int Sum()
	{
		int sum =0;
		for (int i = 0; i < index; i++) {
			
			sum += books[i].price;
		}
		return sum;
	}
	// 평균. 
	public double average()
	{
		return Sum()/index;  
		
	}	
	public void print() {
		System.out.println("북매니저");
		System.out.println("0.종료");
		System.out.println("1.데이터입력");
		System.out.println("2.데이터전체검색");
		System.out.println("3.ISBN으로 검색");
		System.out.println("4.Title로 검색");
		System.out.println("5.Book만 검색");
		System.out.println("6.Magazine만 검색");
		System.out.println("7.출판사로 검색");
		System.out.println("8.가격으로 검색");
		System.out.println("9.입력한 값들의 합계");
		System.out.println("10.입력한 값들의 평균");
		
	}
}
