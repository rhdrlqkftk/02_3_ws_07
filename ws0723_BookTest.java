package ws.ssafy;

import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookManager bm = new BookManager();
		
		while(true) {
			bm.print();
			int userInput = sc.nextInt();			
			switch(userInput) {
			case 0:
				System.exit(0);
				break;
			case 1:
				//�켱 �ð� ������ �Է¸���..
				bm.addBook(new Book("123","�ڹٴ� �ֹ�쳪","��ȿ��","ssafy",1500,"�ڹٴ� �ڹٴ�"));
				bm.addBook(new Book("124","�˰���","������","ssafy",2500,"�˰��� �밡��"));
				bm.addBook(new Magazine("125","DB","������","ssafy",2500,"DBDB" ,2019,7));
				bm.addBook(new Magazine("126","��Ʈ��ũ","������","ssafy",2500,"��Ʈ��ũ" ,2019,5));
				break;
			case 2:
				bm.search();
				break;
			case 3:
				System.out.println("ISBN?");	
				sc.nextLine();
				String isbn = sc.nextLine();
				bm.search(isbn);
				break;
			case 4:
				System.out.println("Title?");	
				sc.nextLine();
				String title = sc.nextLine();
				bm.search(title);
				break;
			case 5:
				bm.searchOnlyBook();
				break;
			case 6:
				bm.searchOnlyMagazine();
				break;
			case 7:
				System.out.println("Publisher?");	
				sc.nextLine();
				String publisher = sc.nextLine();
				bm.searchPublisher(publisher);
				break;
			case 8:
				System.out.println("Price?");	
				sc.nextLine();
				int price = Integer.parseInt(sc.nextLine());
				bm.search(price);
				break;
			case 9:
				System.out.println("�հ�!!");
				System.out.println(bm.sum());
				break;
			case 10:
				System.out.println("���!!");
				System.out.println(bm.average());
				break;
		
			}
			
			
		}
	}
}
