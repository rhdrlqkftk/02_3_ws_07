import java.util.Scanner;

public class Solution3 {
	static int N; 
	static int Map[]; 
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt(); 
		for(int t =1; t <= Tc; t++)
		{
			N = sc.nextInt();
			Map = new int[N];
			for(int i =0 ; i< N ;i++)
			{				
				Map[i] =sc.nextInt(); 
				
			}
			int idx =0, ans =0; 
			while( idx +1 <N )
			{
				int a =0; 
				while( idx +1 < N && Map[idx] <Map[idx+1])
				{
					a++; idx++; 
				}
				while( idx +1 < N && Map[idx] >Map[idx+1])
				{
					ans += a; idx++; 
				}
			}
			System.out.println("#" +t + " " + ans);
		}
	}
}
