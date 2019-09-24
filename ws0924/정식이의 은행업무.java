package SWEX;

import java.util.Scanner;

public class SWHW {
	static int[] master;
	static int[] master1;
	static long ans=0;
	static boolean chk =false; 
	static void solve()
	{
		long d2 =0; 
		long d3 =0; 
		for(int i =0; i< master.length; i++)
		{
			d2 *=2; 
			d2 += master[i];
		}
		for(int i =0; i< master1.length; i++)
		{
			d3 *=3; 
			d3 += master1[i];
		}
		if( d2==d3)
		{
			chk = true; 
			ans = d2; 
		}
		
		return ; 
	}
	static void fs3()
	{
		for( int j =0 ;j < master1.length; j++)
		{
			for(int k =0; k<3; k++)
			{
				if(master1[j]== k) continue;
				int tmp = master1[j]; 
				master1[j]= k;
				solve(); 
				if( chk == true)
				{
					return;
				}
				master1[j]= tmp; 
			}
		}
	}
	static void fs2()
	{
		for(int i=0;  i<master.length; i++)
		{
			if( master[i] == 1)
			{
				master[i] = 0; 
			}
			else 
			{
				master[i] = 1;
			}
			fs3(); 
			if( chk == true)
			{
				return;
			}
			if( master[i] == 1)
			{
				master[i] = 0; 
			}
			else 
			{
				master[i] = 1;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		for(int t = 1; t <= Tc; t++)
		{
			chk = false; 
			String s = sc.next();
			master = new int[s.length()];
			for(int i=0 ; i< s.length(); i++)
			{
				master[i] =  Integer.parseInt(s.charAt(i)+ "");			
			}
			s = sc.next();
			master1 = new int[s.length()];
			for(int i=0 ; i< s.length(); i++)
			{
				master1[i] = Integer.parseInt(s.charAt(i)+ "");			
			}
			fs2();
			System.out.println("#" + t+ " "+ ans);
			
		}
	}
}
