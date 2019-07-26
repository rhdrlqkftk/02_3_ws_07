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
	//데이터 추가.
	public void add( Movie m)
	{
		if(index >= 0 && index <movies.length)
		{
			movies[index++]= m;
		}
	}
	//2 모든 영화 검색 
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
		 
		// 영화 감독
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
		//장르
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
		//삭제
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
		System.out.println("<<< 영화관리 프로그램>>>");
		System.out.println("1. 영화 정보 입력");
		System.out.println("2. 영화 정보 전체 출력");
		System.out.println("3. 영화명 검색");
		System.out.println("4. 영화 장르별 검색");
		System.out.println("5. 영화 삭제");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 입력하세요: ");
	}
}
