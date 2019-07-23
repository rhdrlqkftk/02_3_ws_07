import java.util.Scanner;

public class Solution {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		for (int t = 1; t <= T; t++) 
		{
		float sum=0;
		int N = sc.nextInt();
		for( int i=0; i<N; i++)
		{
			float x =sc.nextFloat();
			float y = sc.nextFloat();
			sum += x*y;
		}
		System.out.println("#" + t + " " +sum);
		}
	}
}