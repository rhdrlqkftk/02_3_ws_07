package WS2222;

import hw.Car;

public class MovieMgr {

	private static MovieMgr manager = new MovieMgr();
	public static MovieMgr getInstance()
	{
		return manager; 
	}
	private Movie [] movies;  
	private int index =0;  
	
	public MovieMgr()
	{
		movies = new Movie[100];
	}
	//������ �߰�.
	public void add( Movie m)
	{
		if(index >= 0 && index <movies.length)
		{
			movies[index++]= m;
		}
	}
	//2 ��� ��ȭ �˻� 
		public Movie[] search()
		{
			Movie a[] = new Movie[index];
			for (int i = 0; i < index; i++) 
			{
				a[i] =movies[i];
			}
			return a;
		}
    /// 
		public Movie[] search(String title)
		{
			Movie a[] = new Movie[index];
			for (int i = 0; i < index; i++) 
			{
				if(movies[i].getTitle().contains(title))
				{
					a[i] = (movies[i]);
				}
			}
			return a;
		}
		 
		// ��ȭ ����
		public Movie[] dir_search(String name)
		{
			Movie a[] = new Movie[index];
			for (int i = 0; i < index; i++) 
			{
				if(movies[i].director.equals(name))
				{
					a[i] = (movies[i]);
				}
			}
			return a;
		}
		//�帣
		public Movie[] genre_search(String name)
		{
			Movie a[] = new Movie[index];
			for (int i = 0; i < index; i++) 
			{
				if(movies[i].genre.equals(name))
				{
					a[i] = (movies[i]);
				}
			}
			return a;
		}
		//����
		public void delete(String name)
		{
			for (int i = 0; i < index; i++) 
			{
				if( movies[i].getTitle().equals(name))
				{
					index--;
					movies[i] = movies[index];
					movies[index] = null;	
				}
			}
		}
		public int Size()
		{
			return index;
		}
		
	public void print() {
		System.out.println("<<< ��ȭ���� ���α׷�>>>");
		System.out.println("1. ��ȭ ���� �Է�");
		System.out.println("2. ��ȭ ���� ��ü ���");
		System.out.println("3. ��ȭ�� �˻�");
		System.out.println("4. ��ȭ �帣�� �˻�");
		System.out.println("5. ��ȭ ����");
		System.out.println("0. ����");
		System.out.println("���ϴ� ��ȣ�� �Է��ϼ���: ");
	}
}
