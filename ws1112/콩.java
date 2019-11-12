package ws1112;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 콩 {
	static Scanner sc= new Scanner(System.in);
	static int N, M, Max; 

	public static void main(String[] args) 
	{
		int T = sc.nextInt();
		for(int tc =1; tc<=T; tc++)
		{
			int cnt =0;
			N =sc.nextInt(); 
			M =sc.nextInt(); 
			for(int i =0; i< N; i++)
			{
				for(int j =0 ; j< M; j++)
				{
					if((i %2 == 0) && (j %2 == 0))
					{
						if( (i +j)%4 ==0)
						{
							cnt++; 
							if( i+1 <N )
							{
								cnt++; 
							}
							if( j+1 <M)
							{
								cnt++;
							}
							if( ( i+1 <N ) && ( j+1 <M))
							{
								cnt++;
							}
						}
					}
				}
			}	
			System.out.println("#" + tc + " "+ cnt);
		}
	}
}
		 

