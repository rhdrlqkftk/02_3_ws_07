package teacher;

import java.util.List;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BooMgrImpl bmgr = BooMgrImpl.getInstance();
		while (true) {
			int userInput = sc.nextInt();
			switch (userInput) {
			case 0:
				System.exit(0);
				break;
			case 1:
				bmgr.add((new Book("fdfd", "dfdfd", "j", "매일", 1000, "냉정과 열정사이")));
				bmgr.add((new Book("2345234", "바보", "JW", "정보", 2000, "집에 가고싶은 ")));
				bmgr.add((new Book("438483", "dfdfd", "j", "매일", 2000, "냉정과 열정사이")));
				bmgr.add(new Magazine("125", "DB", "양유진", "ssafy", 2300, "DBDB", 2019, 7));
				bmgr.add(new Magazine("126", "네트워크", "양유진", "ssafy", 2500, "네트워크", 2019, 5));
			case 2: // 전체 출력력
				List<Book> bs = bmgr.search();
				print(bs);
				break;
			case 3: // 제목에 맞게 출력.
				System.out.println("ISBN?");
				String isn = sc.next();
				System.out.println(bmgr.search(isn).toString());
				break;
			case 4: // 제목에 맞게 출력.
				System.out.println("Title?");
				String tt = sc.next();
				List<Book> gs = bmgr.searchByTitle(tt);
				print(gs);
				break;
			case 5:
				System.out.println("OnlyBook?");
				List<Book> ks = bmgr.searchOnlyBooks();
				print(ks);
				break;
			case 6:
				System.out.println("OnlyMagazine?");
				List<Magazine> ls = bmgr.searchOnlyMaganzins();
				printm(ls);
				break;
			case 7:
				System.out.println("Only This Year Magazine?");
				List<Magazine> tkk = bmgr.ThisyearMaganzins();
				printm(tkk);
				break;
			case 8:
				// 출판사로 검색하는 기능.
				System.out.println("publiser 입력하세요 ");
				String tb = sc.next();
				List<Book> nn = bmgr.searchByPublisher(tb);
				print(nn);
				break;
			case 9:
				System.out.println("가격 입력하세요? (입력가격보다 낮은거 출력)");
				int tdf = sc.nextInt();
				List<Book> fd = bmgr.searchByPrice(tdf);
				print(fd);
				break;
			case 10: // 합계구하기.
				System.out.println("합계 구하기");
				System.out.println( bmgr.sum());
				break;
			case 11: 
				System.out.print("평균 구하기");
				System.out.println( bmgr.average());
				break;

			}
		}
	}

	public static void print(List<Book> bs) {
		System.out.println(" ====================== ");
		for (Book b : bs) {
			System.out.println(b);
		}
	}

	public static void printm(List<Magazine> bs) {
		System.out.println(" ====================== ");
		for (Book b : bs) {
			System.out.println(b);
		}
	}

}
//public Book(String isbn, String title, String author, String publisher, int price, String desc) {
