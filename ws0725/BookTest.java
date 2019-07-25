package WS;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		BookManager manager =  new BookManager(); 
		while(true) {
			manager.print();
			int userInput = sc.nextInt();			
			switch(userInput) {
			case 0:
				System.exit(0);
				break;
			case 1:
		
				manager.addBook((new Book( "fdfd","dfdfd","j","����",2000, "������ ��������")));
				manager.addBook((new Book( "438483","dfdfd","j","����",2000, "������ ��������")));
				manager.addBook((new Book( "2345234","�ٺ�","JW","����",2000, "���� ������� ")));
				manager.addBook(new Magazine("125","DB","������","ssafy",2500,"DBDB" ,2019,7));
				manager.addBook(new Magazine("126","��Ʈ��ũ","������","ssafy",2500,"��Ʈ��ũ" ,2019,5));
			case 2:
				manager.search();
				break;
			case 3:
				System.out.println("ISBN?");	
				sc.nextLine();
				String isbn = sc.nextLine();
				manager.search(isbn);
				break;
			case 4:
				System.out.println("Title?");	
				sc.nextLine();
				String title = sc.nextLine();
				manager.search(title);
				break;
			case 5:
				manager.searchOnlyBook();
				break;
			case 6:
				manager.searchOnlyMagazine();
				break;
			case 7:
				System.out.println("Publisher?");	
				sc.nextLine();
				String publisher = sc.nextLine();
				manager.searchPublisher(publisher);
				break;
			case 8:
				System.out.println("Price?");	
				sc.nextLine();
				int price = Integer.parseInt(sc.nextLine());
				manager.search(price);
				break;
			case 9:
				System.out.println("�հ�");
				System.out.println(manager.Sum());
				break;
			case 10:
				System.out.println("���");
				System.out.println(manager.average());
				break;
		
			}
		// TODO Auto-generated constructor stub
		}
	}
}


	