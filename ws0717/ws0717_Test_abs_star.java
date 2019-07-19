import java.util.Scanner;

public class Test_abs_star {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i <  (2*n)+1; i++) 
		{
			for (int j = 0; j < Math.abs(n - i - 1); j++)
			{
				System.out.print(" ");
			}
			for (int j = 0; j <n -(2*Math.abs(n - i - 1)) ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
