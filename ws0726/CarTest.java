package hw;

import java.util.Scanner;

public class CarTest {
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		CarMgr mg = CarMgr.getInstance();
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
					mg.add(new Car("123455", "�����ڵ���", 2008));
					mg.add(new Car("55555","�ֿ��ڵ���", 345));
					mg.add(new Bus("3455","���ڵ���", 345, 1000));
					mg.add(new Bus("1435","����", 934345 , 100));
					mg.add(new Truck("2355","�ƿ��", 73454444, 5));
					mg.add(new Bus("145","����ι�", 1934345 , 250));
					mg.add(new Truck("25","�����ٰ�", 473454444, 15));
					break;
				case 2: 
					int num = mg.Size(); 
					Car[] a = new Car[num];
					a = mg.search();
					for (int i = 0; i < a.length; i++) 
					{
						System.out.println(a[i]);
					}
					break;
				case 3: 
					System.out.println("ISBN?");
					sc.nextLine();
					String isbn = sc.nextLine();
					System.out.println( mg.search(isbn));
					break;
				
				case 4:  //���ݺ��� �� ��ǰ �˻�. 
					System.out.println("low Price?");
					int pp = sc.nextInt();
					Car[] d =  mg.price_search(pp);
					int i=0;
					for (int j = 0; j < d.length; j++) 
					{
						if(d[i]==null)continue;
						System.out.println(d[i]);
						i++;
					}
					break;
				case 5: 
					System.out.println("���� ��ȣ �Է�, ���� �Է�");
					String numm = sc.next();
					int priice = sc.nextInt();
					mg.revise(numm, priice);
					System.out.println(mg.search(numm));
					break;
				case 6: 
					System.out.println("������ ���� ��ȣ�� �Է�:");
					String nu = sc.next();
					mg.delete(nu);
					System.out.println("�����Ǿ����ϴ�.");
					break;
				case 7: //System.out.println("7. �ڵ��� ���");
					int j = mg.Size(); 
					System.out.println("������� : "+ j);
				case 8:
					int sum = mg.TotalPrice();
					System.out.println("�Ѱ���: "+ sum);
			}	
		}
	}
}
/*public void print() {
		System.out.println("Car�Ŵ���");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ ��ü���");
		System.out.println("3. ������ȣ �˻�");
		System.out.println("4. ���ݺ��� �� ��ǰ �˻�");
		System.out.println("5. �˻��� ����");
		System.out.println("6. ���� ");
		System.out.println("7. �ڵ��� ���");
		System.out.println("8. �Ѱ���");
		System.out.println("0. ����");	
	}
 * */
