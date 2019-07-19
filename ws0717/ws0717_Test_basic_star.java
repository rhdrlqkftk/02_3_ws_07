import java.util.Scanner;

public class Test_basic_star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		for( int i=0 ; i  <n; i++)
		{
			for (int j = 0; j<n-i-1; j++)
			{
				System.out.print(" ");
			}	
			for (int j = 0; j < 2*i+1; j++) 
			{
				System.out.print("*");
			}
			System.out.println();
		}	
		int k = n-1;
		for( int i=0 ; i<k; i++)
		{
			for (int j = 0; j<i+1; j++)
			{
				System.out.print(" ");
			}	
			for (int j = 2*(k-i)-1; j >0; j--) 
			{
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
