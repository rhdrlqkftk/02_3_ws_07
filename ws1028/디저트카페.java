package ws1028;

import java.util.Scanner;

public class 디저트카페 {
	static int Map[][] , N, Max;
	static boolean visit[][] ;
	static boolean num[]; 
	static int Sx , Sy;
	static int dx[] ={1,1,-1,-1};
	static int dy[] ={1,-1,-1,1};
	static boolean boundary(int x,int y)
	{
		if( x <0 || y < 0 || x >= N || y >= N)
		{
			return false; 
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc =1 ;tc<=T; tc++)
		{
			N= sc.nextInt();
			Map = new int[N][N];
			
			for(int i =0; i < N ; i++)
			{
				for(int j =0; j < N; j++)
				{
					Map[i][j] = sc.nextInt();
				}
			}
			
			Max = 0;
			for(int i =0; i < N-2; i++)
			{
				for(int j =1; j < N-1; j++)
				{
					visit = new boolean[N][N]; 
					num = new boolean[101];
					visit[i][j] =true;
					num[Map[i][j]] =true;
					Sx =i; 
					Sy =j;					
					dfs( i, j, 0);
				}
			}
		
			if( Max ==0) Max =-1; 
			
			System.out.println("#"+tc+" "+ Max); 
		}
	}
	static int pre[]= new int[4];
	static void dfs(int x, int y, int idx)
	{
		if(idx !=0 && pre[idx-1]==0) return; 
		for(int i =idx; i <=idx+1; i++)
		{
			if( i == 4)continue;
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!boundary(nx,ny)) continue;
			if( nx == Sx && ny == Sy )
			{
				int sum =0;
				for( int g =0;g <101;g++)
				{
					if( num[g] ==true)
					{
						sum += 1;
					}
				}
				if(Max <sum)
				{
					Max = sum;
				}
				return;
			}
			if(visit[nx][ny] ==false && num[Map[nx][ny]] ==false)
			{
				num[Map[nx][ny]] = true;
				visit[nx][ny] = true; 
				pre[i]++;
				dfs(nx, ny, i);
				pre[i]--;
				visit[nx][ny] = false; 
				num[Map[nx][ny]] = false;
			}
			
		}
	}

}
