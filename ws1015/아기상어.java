package ssafy1015;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어 {
	static int N;
	static int Map[][];
	static int visit[][];
	static int time;
	static int dx[] = {0,1,0,-1}; 
	static int dy[] = {1,0,-1,0};
	static class pair
	{
		int x; 
		int y; 
		pair(int x,int y)
		{
			this.x =x; 
			this.y =y;
		}
	}
	static class Point implements Comparable<Point>
	{
		int x; 
		int y; 
		int dis;
		Point(int x,int y, int dis)
		{
			this.x =x; 
			this.y =y;
			this.dis =dis;
		}
		@Override
		public int compareTo(Point o) 
		{
			if( this.dis == o.dis)
			{
				if( this.x == o.x)
				{
					return this.y -o.y; 
				}
				return this.x - o.x; 	
			}
			return this.dis- o.dis;
		}
	}


	static boolean boundary(int x,int y)
	{
		if( x < 0 || y < 0 || x >=N || y >= N)
		{
			return false; 
		}
		return true;
	}
	static PriorityQueue<Point>qq = new PriorityQueue<>();
	static Queue<pair>q =new LinkedList<pair>();
	static int sx,sy, ss, Sc; 
	static void bfs(int x,int y)
	{
		q.add(new pair(x,y));
		while(!q.isEmpty())
		{
			pair p = q.poll();
			for(int i =0; i<4; i++)
			{
				int nx  = p.x +dx[i];
				int ny  = p.y +dy[i];
				if( !boundary(nx,ny))continue; 
				if(visit[nx][ny] ==0 && Map[nx][ny]<=ss)
				{
					visit[nx][ny] = visit[p.x][p.y]+1; 
					q.add(new pair( nx,ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Map = new int[N][N];
		
		int dist=0;
		for(int i =0 ; i <N; i++)
		{
			for(int j =0 ; j <N; j++)
			{
				Map[i][j] = sc.nextInt();
				
				if( Map[i][j] == 9)
				{
					sx = i; 
					sy = j; 
					ss = 2; 
					Sc = 0;
					Map[i][j] = 0;
				}
			}
		}
		while(true)
		{
			visit = new int[N][N];
			bfs(sx, sy); //상어의 위치로 부터 쭉 다 더 해준거지 !?
			//상어의 위치를 구한 다음에 뭐하냐? 
			for(int i =0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					//상어 사이즈보다 작은놈 
					if(Map[i][j] > 0 && Map[i][j] <ss)
					{
						if(visit[i][j]>0)
						{							
							qq.add(new Point(i,j,visit[i][j] ));	
						}
					}
				}
			}
			if(qq.size() ==0) break;
			Point pp = qq.poll();  //qq 에는 물고기 사이즈 , 거리.
			dist += pp.dis; 
			sx = pp.x;
			sy = pp.y;
			Map[pp.x][pp.y] =0; // 0이다. 
			Sc++; 
			if( Sc == ss)
			{
				ss++; 
				Sc=0;
			}
			qq.clear();
		}
		System.out.println(dist);
	}
}
