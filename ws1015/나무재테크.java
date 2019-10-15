package ssafy1015;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 나무제태크 {
	static int N, M, K; 
	static PriorityQueue<pair> pq = new PriorityQueue<>();
	static PriorityQueue<pair> nq = new PriorityQueue<>();
	static PriorityQueue<pair> dq = new PriorityQueue<>();
	static int Map[][]; 
	static int MMap[][];
	static int dx[] = {0,1,0,-1, 1,1,-1,-1};
	static int dy[] = {1,0,-1,0, 1,-1,1,-1};
	static boolean boundary(int x,int y)
	{
		if( x <= 0 || y <= 0 || x >N || y > N)
		{
			return false; 
		}
		return true;
	}
	static class pair implements Comparable<pair>
	{
		int x; 
		int y; 
		int age; 
		pair(int x, int y, int age)
		{
			this.x = x; 
			this.y = y;
			this.age = age; 
		}
		@Override
		public int compareTo(pair o) 
		{
			return this.age- o.age;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		N = sc.nextInt(); 
		M = sc.nextInt(); // 나무 갯수를 말함. 
		K = sc.nextInt(); 
		Map = new int[N+1][N+1];
		MMap = new int[N+1][N+1];
		for(int i =1;i <= N; i++)
		{
			for(int j=1; j <= N; j++)
			{
				Map[i][j] = 5;
				MMap[i][j] = sc.nextInt();
			}
		}
		int x, y, z; 
		pair p[] = new pair[M];
		for(int i =0 ; i < M; i++)
		{
			x = sc.nextInt(); 
			y = sc.nextInt(); 
			z = sc.nextInt(); 
			pq.add(new pair(x,y,z));
		}
		int k =0; //처음을 0으로 할것인가 1로 할 것인가 고민.
		while(k < K)
		{
			while(!pq.isEmpty())
			{
				pair pe =pq.poll(); 
				if((Map[pe.x][pe.y] - pe.age) >= 0) // 
				{
					Map[pe.x][pe.y] -= pe.age; 
					nq.add(new pair( pe.x,pe.y , pe.age+1));//새로운 나무들이 생겨남.  
					if( (pe.age+1) %5 ==0)
					{
						for(int d =0;d <8;d++)
						{
							int nx = pe.x+ dx[d];
							int ny = pe.y+ dy[d];
							if(!boundary(nx,ny))continue; 
							nq.add(new pair(nx,ny, 1));
						}
					}
				}
				else
				{
					// 죽어 
					dq.add( new pair(pe.x,pe.y,pe.age/2));
				}
			}
			// 여름
			while(!dq.isEmpty())
			{
				pair pe = dq.poll(); 
				Map[pe.x][pe.y] += pe.age;
			}
			// 겨울
			for(int i =1; i <= N; i++)
			{
				for(int j=1; j <= N; j++)
				{
					Map[i][j] += MMap[i][j] ;
				}
			}
			pq.clear();
			pq.addAll(nq);
			nq.clear();
			k++;
		}
		int size = pq.size();
		System.out.println(size);
	}
}
