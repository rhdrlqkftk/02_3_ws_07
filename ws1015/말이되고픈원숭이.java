package ssafy1015;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이 {
	static int K, W, H, Map[][], ans; 
	static int TMap[][][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int hx[] ={-1,1 ,2,2, 1,-1,-2,-2 };
	static int hy[] ={ 2,2,1,-1,-2,-2,-1,1 };
	static class pair 
	{
		int x; 
		int y; 
		int cnt;
		pair(int x, int y, int cnt)
		{
			this.x = x; 
			this.y = y;
			this.cnt= cnt;
		}
	}
	static Queue<pair> q = new LinkedList<pair>();
	static boolean boundary(int x,int y)
	{
		if( x < 0 || y < 0 || x >=H || y >= W)
		{
			return false; 
		}
		return true;
	}
	static void bfs()
	{
		TMap[0][0][0] =0;
		q.add(new pair(0,0,0));
		while(!q.isEmpty())
		{
			pair p= q.poll(); 
			
			for(int i =0; i <4; i++)
			{
				int nx = p.x +dx[i];
				int ny = p.y +dy[i];
				
				if(!boundary(nx,ny))continue;
				if( Map[nx][ny] == 1)continue;
				if(nx == H-1 && ny == W-1)
				{
					if( ans > TMap[p.cnt][p.x][p.y])
					{
						ans = TMap[p.cnt][p.x][p.y]+1;
					}
					return;
				}
				if(TMap[p.cnt][nx][ny] ==0 )
				{
					TMap[p.cnt][nx][ny] = TMap[p.cnt][p.x][p.y] +1 ;
					q.add(new pair( nx,ny,p.cnt));
				}
			}	
			// K는 최대 30번 주어진다. 
			if( p.cnt < K)
			{
				for(int i =0; i<8;i++)
				{
					int nx = p.x +hx[i];
					int ny = p.y +hy[i];
					if( !boundary(nx,ny))continue;
					if( Map[nx][ny] == 1)continue;
					if(nx == H-1 && ny == W-1)
					{
						if( ans > TMap[p.cnt][p.x][p.y] )
						{
							ans = TMap[p.cnt][p.x][p.y]+1;
						}
					}
					
					if(TMap[p.cnt+1][nx][ny]==0)
					{
						TMap[p.cnt+1][nx][ny] = TMap[p.cnt][p.x][p.y] +1 ;
						q.add(new pair(nx,ny,p.cnt+1));
					}
				}
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); 
		W = sc.nextInt();
		H = sc.nextInt();
		Map = new int[H][W];
		TMap= new int[31][H][W];
		ans = Integer.MAX_VALUE; // 이 값보단 무조건 작기 때문이다. 
		for(int i =0;i < H; i++)
		{
			for(int j=0; j < W; j++)
			{
				Map[i][j] = sc.nextInt();
			}
		}
		
		bfs(); 
		if( ans == Integer.MAX_VALUE)
		{
			System.out.println(-1);
		}
		else 
		{
			System.out.println(ans);
		}
		// 0,0에서 시작. H-1,W-1에서 끝. 
	}
}
