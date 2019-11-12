package ws1112;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈주범 {
	static int N, M, r,c, L; 
	static int Map[][]; 
	static boolean visit[][]; 
	static Queue<pair> q ;  
	static class pair
	{
		int x; int y; 
		pair(int x1, int y1)
		{
			x =x1; 
			y =y1;
		}
	}
	static int dx[] = {0,1,0,-1}; 
	static int dy[] = {1,0,-1,0}; 
	static boolean boundary(int x, int y )
	{
		if( x < 0 || y < 0 || x >= N || y >= M)
		{
			return false; 
		}
		return true;
	}
	static boolean check( int num,  int d)
	{
		if( num == 1)
		{
			return true;
		}
		else if( num == 2)
		{
			if( d == 1 || d ==3)
			{
				return true;
			}
			else 
			{
				return false; 
			}
		}
		else if( num == 3)
		{
			if( d == 0 || d == 2)
			{
				return true;
			}
			return false;
		}
		else if( num == 4)
		{
			if( d ==3 || d == 0)
			{
				return true; 
			}
			else 
			{
				return false;
			}
		}
		else if( num == 5)
		{
			if( d ==0||d == 1)
			{
				return true; 
			}
			else 
			{
				return false;
			}
		}
		else if( num == 6)
		{
			if( d ==1||d == 2)
			{
				return true; 
			}
			else 
			{
				return false;
			}
		}
		else if( num == 7)
		{
			if( d ==2||d == 3)
			{
				return true; 
			}
			else 
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	//1~7 까지 터널이 주어진다.
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int T =sc.nextInt(); 
		for(int tc =1; tc<=T;tc++)
		{
			// N , M , r,c, time  세로 가로 세로 가로	
			N =sc.nextInt();
			M =sc.nextInt();
			
			r =sc.nextInt();
			c =sc.nextInt();
			L =sc.nextInt();
			q= new LinkedList<pair>();
			q.add(new pair( r, c));
			
			Map = new int[N][M];
			visit= new boolean [N][M];
			for(int i=0; i < N; i++)
			{
				for(int j =0; j <M;j++)
				{
					Map[i][j] =sc.nextInt();
				}
			}
		
			visit[r][c] = true;
			int cnt=1;
			int time = 1; // 처음이 1로 시작하는구나.
			while( time < L)
			{
				int size = q.size();
				for(int g=0;g<size; g++)
				{
					pair p = q.poll(); 
					for(int i =0 ;i<4;i++)
					{
						if(check( Map[p.x][p.y], i))
						{
							int nx = p.x + dx[i]; 
							int ny = p.y + dy[i];
							if( !boundary(nx,ny))continue;
							if( Map[nx][ny]== 0) continue;
							int rev=0;
							if( i == 0 ) rev = 2; 
							else if( i == 1 ) rev = 3; 
							else if( i == 2 ) rev = 0; 
							else if( i == 3 ) rev = 1;
							if(check( Map[nx][ny], rev) && visit[nx][ny]==false)
							{
								visit[nx][ny] =true;
								q.add(new pair(nx,ny));
								cnt++;
							}
						}
					}
				}
				time ++;
			}
			
			System.out.println("#"+ tc + " " +  cnt);
		}
	}
}
