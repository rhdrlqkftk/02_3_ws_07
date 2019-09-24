import java.util.Scanner;

public class Solution {
	static int n; 
	static int m; 
	static long Map[]; 
	static class Point 
	{
		int x; 
		int y; 
		Point(int x, int y)
		{
			this.x = x; 
			this.y = y; 
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt(); 
		for(int t =1; t <= Tc; t++)
		{
			n = sc.nextInt();
			Map = new long[n];
			for(int i =0 ; i< n ;i++)
			{				
				Map[i] =sc.nextLong(); 
				
			}
			int cnt1 =0; 
			int cnt2 =0; 
			int res =0; 
			boolean b  = true; 
			for(int k =0;k <n-1;k++)
			{
				if( b == true && Map[k+1] >Map[k])
				{
					cnt1++; 
				}
				else if( b== false && Map[k+1] > Map[k])
				{
					b = true; 
					res += cnt1 * cnt2; 
					cnt1 =1; 
					cnt2 =0;  		
				}
				else if( b == true && Map[k+1] < Map[k])
				{
					b = false; 
					cnt2++;  
				}
				else if( b == false && Map[k+1] < Map[k])
				{
					cnt2++;  
				}
			}
			res += cnt1 * cnt2;
			System.out.println("#" + t+ " "+res);
		}
	}
}
