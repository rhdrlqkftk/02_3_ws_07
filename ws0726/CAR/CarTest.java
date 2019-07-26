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
					mg.add(new Car("123455", "현대자동차", 2008));
					mg.add(new Car("55555","쌍용자동차", 345));
					mg.add(new Bus("3455","용자동차", 345, 1000));
					mg.add(new Bus("1435","벤츠", 934345 , 100));
					mg.add(new Truck("2355","아우디", 73454444, 5));
					mg.add(new Bus("145","랜드로버", 1934345 , 250));
					mg.add(new Truck("25","폭스바겐", 473454444, 15));
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
				
				case 4:  //가격보다 싼 제품 검색. 
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
					System.out.println("차량 번호 입력, 가격 입력");
					String numm = sc.next();
					int priice = sc.nextInt();
					mg.revise(numm, priice);
					System.out.println(mg.search(numm));
					break;
				case 6: 
					System.out.println("삭제할 차량 번호를 입력:");
					String nu = sc.next();
					mg.delete(nu);
					System.out.println("삭제되었습니다.");
					break;
				case 7: //System.out.println("7. 자동차 댓수");
					int j = mg.Size(); 
					System.out.println("차량댓수 : "+ j);
				case 8:
					int sum = mg.TotalPrice();
					System.out.println("총가격: "+ sum);
			}	
		}
	}
}
/*public void print() {
		System.out.println("Car매니저");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 전체출력");
		System.out.println("3. 차량번호 검색");
		System.out.println("4. 가격보다 싼 제품 검색");
		System.out.println("5. 검색후 수정");
		System.out.println("6. 삭제 ");
		System.out.println("7. 자동차 댓수");
		System.out.println("8. 총가격");
		System.out.println("0. 종료");	
	}
 * */
