package WS;

public class BookManager {

	private Book [] books;  
	private int index =0;  
	public BookManager() 
	{
		books = new Book[100]; // ��ü �����Ȱžƴϴ�. �ڸ� Ȯ���� �ȰŴ�.!
	}
	//å �߰� 
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
	// ��ü �˻�. 
	public void search()
	{
		for (int i = 0; i < index; i++) {
			System.out.println(books[i]);
		}
	}	
	
	// isbn���� �˻� 
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
	// book�� �˻�. 
	public void searchOnlyBook( )
	{
		for (int i = 0; i < index; i++) {
			if (!(books[i] instanceof Magazine)) {
				System.out.println(books[i]);
			}
		}
	}
	// title�� �˻�. 
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

	// �������ϰ˻�
		public void search(int price) {
			for (int i = 0; i < index; i++) {
				if (books[i].price< price) {
					System.out.println(books[i]);
				}
			}
		}

	// ���ǻ� �˻� 
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
	// Magazine�� �˻� 
	public void searchOnlyMagazine() {
		for (int i = 0; i < index; i++) {
			if (books[i] instanceof Magazine) {
				System.out.println(books[i]);
			}
		}

	}
	// �߰� �ϱ� .
	public int Sum()
	{
		int sum =0;
		for (int i = 0; i < index; i++) {
			
			sum += books[i].price;
		}
		return sum;
	}
	// ���. 
	public double average()
	{
		return Sum()/index;  
		
	}	
	public void print() {
		System.out.println("�ϸŴ���");
		System.out.println("0.����");
		System.out.println("1.�������Է�");
		System.out.println("2.��������ü�˻�");
		System.out.println("3.ISBN���� �˻�");
		System.out.println("4.Title�� �˻�");
		System.out.println("5.Book�� �˻�");
		System.out.println("6.Magazine�� �˻�");
		System.out.println("7.���ǻ�� �˻�");
		System.out.println("8.�������� �˻�");
		System.out.println("9.�Է��� ������ �հ�");
		System.out.println("10.�Է��� ������ ���");
		
	}
}
