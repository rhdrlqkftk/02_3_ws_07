// 정렬 연습하기 좋은 문제다. 
package afternoon;
import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
	static int N, S_x, S_y, E_x, E_y, Min; 
	static Person arr[];

	static class Person
	{
		int x; 
		int y; 
		boolean chk;
		Person(int x,int y , boolean chk)
		{
			this.x = x; 
			this.y = y; 
			this.chk = chk; 
		}
	}
	static int cal( int sx , int sy, int ex, int ey)
	{		
		return  Math.abs(sx-ex) + Math.abs(sy-ey);
	}
	static void dfs( int sx , int sy, int K, int sum)
	{
		if(K == N)
		{
			sum +=  cal( sx, sy, E_x, E_y );
			if( Min> sum)
			{
				Min = sum;
			}
			return ; 
		}
		if ( sum > Min) // 아직 완성되진 않았지만 더 해도  필요없다. 
		{
			return ; 
		}
		
		for(int i =0 ; i<N;i++)
		{
			if( arr[i].chk == false)
			{
				arr[i].chk = true; 
				sum += cal(sx, sy , arr[i].x, arr[i].y); 
				dfs(arr[i].x, arr[i].y, K+1 , sum );
				sum -= cal(sx, sy , arr[i].x, arr[i].y); 
				arr[i].chk = false; 
			}
		}
		
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int t =1 ;t<=T;t++)
		{
			N =sc.nextInt();
			S_x = sc.nextInt(); 
			S_y = sc.nextInt(); 
			E_x = sc.nextInt(); 
			E_y = sc.nextInt();	
			arr = new Person[N];
			Min= Integer.MAX_VALUE; //초기화 필요. 
			for(int i =0 ; i <N; i++)
			{
				arr[i] = new Person(sc.nextInt(), sc.nextInt(), false);
			}
			dfs( S_x, S_y, 0,0);	
			System.out.println("#"+t + " " + Min);
		}
		
	}
}



/*
 * 
 * 
10
5
0 0 100 100 70  40 30 10 10 5  90 70 50 20
6
88 81 85 80 19  22 31 15 27 29  30 10 20 26 5  14
10
39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36
...
 *
 */