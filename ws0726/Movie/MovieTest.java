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
					mg.add(new Movie("Ÿ��Ÿ��", "��Ʈ��",10, "�θེ", "��մ���̴ٽ����ٻ���Ѵ�"));
					mg.add(new Movie("�˶��", "����Ŀ",8, "��Ÿ��", "��մ���̴ٽ�����"));
					mg.add(new Movie("�����", "����ȣ",2, "���", "�����ٻ���Ѵ�"));
					mg.add(new Movie("�����", "��ũ��",9, "�׼�", "����Ѵ�"));
					mg.add(new Movie("�����̴���", "����",9, "�׼�", "��մ�"));
					mg.add(new Movie("�±ر�", "����",3, "�׼�", "��մ���̴�"));
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
					System.out.println("��ȭ����?");
					sc.nextLine();
					String isbn = sc.nextLine();
					Movie [] t= mg.search(isbn);
					for (int i = 0; i < t.length; i++) {
						if(t[i]==null) continue;
						System.out.println(t[i]);
					}
					break;
					
				case 4: //�帣�� �˻�. 
					System.out.println("��ȭ�帣 �˻��ؔg");
					sc.nextLine();
					String ss = sc.nextLine();
					Movie [] ct= mg.genre_search(ss);
					for (int i = 0; i < ct.length; i++) {
						if(ct[i]==null) continue;
						System.out.println(ct[i]);
					}
					break;
					
				case 5:  //����.
					System.out.println("������ ��ȭ:");
					String nu = sc.next();
					mg.delete(nu);
					System.out.println("�����Ǿ����ϴ�.");
					break;
					
			}
		}
	}

}
/*
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
 */