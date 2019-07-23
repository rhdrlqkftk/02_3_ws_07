import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 주관식 문제. (대문자)
		String a[];
		for (int t = 1; t <= T; t++) 
		{
			int N = sc.nextInt();
			a =  new String[N];
			for(int i =0 ; i<N; i++)
			{
				a[i] = sc.next();
			}
			Arrays.sort(a);
			int len =0;
			char ac ='A';
			int cnt=0;
			int val=0;
			for(int i=0;i<a.length;i++)
			{
				
				if( ac+cnt >= a[i].charAt(0) && ac <= a[i].charAt(0))
				{
					if(ac+cnt== a[i].charAt(0) )
					{
						cnt++;
					}
				}
				else
				{

					break;
				}	
			}
			System.out.println("#" + t + " " +cnt);
		}	
	}
}
