package ssafy1007;
import java.util.PriorityQueue;
//N, M(1 ≤ N, M ≤ 2,000)
// 문제의 목적: 
// 해결 방안.
import java.util.Scanner;

public class 종구 {
	
	static int dx[] = { 0, 1};
	static int dy[] = { 1, 0 };
	static int N,M; 
	static char map[][] ;
	static boolean visit[][] ;	
	static boolean boundary(int x, int y)
	{
		if( x <= 0 || y <= 0 || x >N || y >M)
		{
			return false; 
		}
		return true;
	}
	static class pair implements Comparable<pair>
	{
		int x; 
		int y; 
		char r; 
		pair( int x, int y, char r)
		{
			this.x =x; 
			this.y = y; 
			this.r = r; 
		}
		@Override
		public int compareTo(pair o) {
			return this.r - o.r;
		}
	}
	static StringBuilder ans = new StringBuilder();
	static void bfs(int x,int y)
	{
		
		for (int i = 0; i < 2; i++) 
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!boundary(nx, ny))
				continue;
			if (nx == N && ny == M) 
			{
				return;
			}
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt(); 
		for(int tc = 1; tc <=T; tc++)
		{
			N = sc.nextInt(); 
			M = sc.nextInt();
			map = new char[N][M];
			for(int i =0 ; i< N; i++)
			{
				String s  = sc.next(); 
				for (int j = 0; j< M; j++) 
				{
					map[i][j] = s.charAt(j);
				}
			}
			PriorityQueue<pair> pq1 = new PriorityQueue<>(); 
			PriorityQueue<pair> pq2 = new PriorityQueue<>();
			bfs(0, 0);
		}
	}
}
