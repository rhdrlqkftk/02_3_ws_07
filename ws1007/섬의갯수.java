package ssafy1007;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬의갯수 {
	static int w,h;  
	static int map[][]; 
	static boolean visited[][]; 
	
	static int dx[] = {0,1,0,-1, 1,-1,-1, 1};
	static int dy[] = {1,0,-1,0, 1,-1, 1,-1};
	static boolean boundary(int x,int y)
	{
		if( x< 0 || y < 0 || x >= h || y >= w )
		{
			return false; 
		}
		return true; 
	}
	static class pair
	{
		int x; 
		int y; 
		pair(int _x, int _y)
		{
			x = _x; 
			y = _y;
		}
	}
	static Queue<pair> q = new LinkedList<pair>();
	static void bfs(int x,int y)
	{
		visited[x][y] = true;
		q.add(new pair(x,y));
		while(!q.isEmpty())
		{
			pair p = q.poll();
			for(int i=0;i < 8; i++)
			{
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				// 바운더리를 넘어서면 continue 해준다. 
				if(!boundary(nx , ny))
				{
					continue;
				}
				if( visited[nx][ny] == true)
				{
					continue;
				}
				if( map[nx][ny] == 1)
				{
					q.add(new pair(nx,ny));
					visited[nx][ny] =true;					
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			w = sc.nextInt(); //5
			h = sc.nextInt(); //4
			if( w ==0 && h ==0)
			{
				break; 
			}
			visited= new boolean [h][w];
			map = new int[h][w];//1은 땅, 0은 바다이다.
			boolean count =false;
			for(int i=0 ; i < h; i++)
			{
				for(int j=0 ; j< w; j++)
				{
					map[i][j] = sc.nextInt(); 
				}
			}
			int cnt=0;
			for(int i=0 ; i < h; i++)
			{
				for(int j=0 ; j< w; j++)
				{
					if( visited[i][j] == false && map[i][j] ==1)
					{
						cnt++; 
						bfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
		
			
	}
}
