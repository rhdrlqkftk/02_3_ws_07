import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int arr[] ; 
		for (int t = 1; t <= T; t++) 
		{
			int N = sc.nextInt();
			int D = sc.nextInt();
			arr = new int[N];
			for(int i =0 ; i<N; i++)
			{
				arr[i]  = sc.nextInt();
			}
			int cnt=0;
			int cnt1=0;
			for(int i =0 ; i<N; i++)
			{
				if( arr[i] == 0 )
				{
					cnt++; 
				}
				else if (arr[i] == 1)
				{
					cnt=0;
				}
				if( cnt == D)
				{
					arr[i]=1;
					cnt =0;
					cnt1 ++;
				}
			}
			System.out.println("#" + t + " " +cnt1);
		}
	}
}
