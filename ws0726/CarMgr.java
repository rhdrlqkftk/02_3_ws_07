package hw;

public class CarMgr 
{
	private static CarMgr carmanager = new CarMgr();
	public static CarMgr getInstance()
	{
		return carmanager; 
	}
	private Car [] cars;  
	private int index =0;  
	public CarMgr()
	{
		cars = new Car[100];
	}
	public void add( Car c)
	{
		if(index >= 0 && index <cars.length)
		{
			cars[index++]= c;
		}
	}
	//2 ��� ���� �˻� 
	public Car[] search()
	{
		Car a[] = new Car[index];
		for (int i = 0; i < index; i++) 
		{
			a[i] = cars[i];
		}
		return a;
	}
	
	// 3���� ��ȣ�� �˻� 
	public Car search(String n)
	{
		Car a = new Car();
		for (int i = 0; i < index; i++) 
		{
			if(cars[i].num.equals(n))
			{
				a = cars[i];			
			}
		}
		return a;
	}
	//4 ���ݺ��� �� ���� ��� 
	public Car[] price_search(int price)
	{
		Car a[] = new Car[index];
		int cnt=0;
		for (int i = 0; i < index; i++) 
		{
			if( cars[i].price <=price)
			{
				a[cnt++] = cars[i];
			}
		}
		return a; 
	}
	public void revise( String num, int price )
	{
		search(num).setPrice(price);	
	}
	//6
	public void delete(String name)
	{
		for (int i = 0; i < index; i++) 
		{
			if( cars[i].getNum().equals(name))
			{
				index--;
				cars[i] = cars[index];
				cars[index] = null;	
			}
		}
	}
	//7
	public int Size()
	{
		return index;
	}
	public int TotalPrice()
	{
		int sum =0;
		for (int i = 0; i < index; i++) {
			
			sum += cars[i].price;
		}
		return sum;
	}
	public void print() {
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

	
}
