// 최적경로
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
		if ( sum > Min) // 이거 한줄 추가해주었더니 1503ms에서 356ms로 줄었다. 
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
			Min= Integer.MAX_VALUE; 
			for(int i =0 ; i <N; i++)
			{
				arr[i] = new Person(sc.nextInt(), sc.nextInt(), false);
			}
			dfs( S_x, S_y, 0,0);	
			System.out.println("#"+t + " " + Min);
		}
		
	}
}

