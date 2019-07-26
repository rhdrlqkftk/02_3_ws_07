package WS2222;
import java.util.Scanner;

import hw.Bus;
import hw.Car;
import hw.Truck;

public class MovieTest {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		MovieMgr mg = MovieMgr.getInstance();
		while (true) 
		{
			mg.print();
			int userInput = sc.nextInt();
			switch (userInput) 
			{
				case 0:
					System.exit(0);
					break;
				case 1:
		     	   //String title, String director, int grade, String genre, String summary		
					mg.add(new Movie("타이타닉", "존트라",10, "로멘스", "재밌다즐겁다슬프다사랑한다"));
					mg.add(new Movie("알라딘", "존워커",8, "판타지", "재밌다즐겁다슬프다"));
					mg.add(new Movie("기생충", "봉준호",2, "드라마", "슬프다사랑한다"));
					mg.add(new Movie("어벤져스", "닥크템",9, "액션", "사랑한다"));
					mg.add(new Movie("스파이더맨", "딕톡",9, "액션", "재밌다"));
					mg.add(new Movie("태극기", "존라",3, "액션", "재밌다즐겁다"));
					break;
				case 2: 
					int num = mg.Size(); 
					Movie[] a = new Movie[num];
					a = mg.search();
					for (int i = 0; i < a.length; i++) 
					{
						System.out.println(a[i]);
					}
					break;
				case 3: 
					System.out.println("영화명뭐야?");
					sc.nextLine();
					String isbn = sc.nextLine();
					Movie [] t= mg.search(isbn);
					for (int i = 0; i < t.length; i++) {
						if(t[i]==null) continue;
						System.out.println(t[i]);
					}
					break;
					
				case 4: //장르별 검색. 
					System.out.println("영화장르 검색해봥");
					sc.nextLine();
					String ss = sc.nextLine();
					Movie [] ct= mg.genre_search(ss);
					for (int i = 0; i < ct.length; i++) {
						if(ct[i]==null) continue;
						System.out.println(ct[i]);
					}
					break;
					
				case 5:  //삭제.
					System.out.println("삭제할 영화:");
					String nu = sc.next();
					mg.delete(nu);
					System.out.println("삭제되었습니다.");
					break;
					
			}
		}
	}

}
/*
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
 */