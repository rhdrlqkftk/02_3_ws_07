import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 0234872
public class Solution2{
	//내림 차순 또는 오름 차순으로 정렬이 된다. 
	// 정렬에 필요한 최소 
	static int N, M; 
	static int Map[][];
	static boolean visited[][];
	static int dx[]  = {0,1,0,-1}; 
	static int dy[]  = {1,0,-1,0};
	
	static boolean boundary(int x, int y)
	{
		if( x < 0 || y < 0 || x >= N || y >= N)
		{
			return false; 
		}
		return true; 
	}
	static PriorityQueue<pair> q = new PriorityQueue<pair>(new MyComp());
	static class MyComp implements Comparator<pair>
	{

		@Override
		public int compare(pair o1, pair o2) {
			// TODO Auto-generated method stub
			if( o1.dis == o2.dis)
			{
				// 행
				return o1.x - o2.x; 
			}
			return o1.dis - o2.dis;
		}
		
	}
	static class pair
	{
		int x; 
		int y; 
		int dis; 
		pair( int x1, int y1, int dis1)
		{
			x =x1; 
			y =y1; 
			dis = dis1; 
		}
	}
	
	static void bfs(int x, int y )
	{
		int tx = x; 
		int ty = y;
		while( boundary(tx,y) ==true && Map[tx][y] != 0) // 행찾기. 
		{
			tx++; 
		}
		while( boundary(x,ty) ==true &&Map[x][ty] != 0) // 행찾기. 
		{
			ty++; 
			
		}
		for(int i =x; i< tx; i++)
		{
			for(int j =y; j< ty; j++)
			{
				  visited[i][j] = true;
			}
		}
		
		int x_d = tx -x; 
		int y_d = ty -y;  
		int dic = x_d * y_d;
		q.add(new pair( x_d, y_d, dic));
		
		
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t= 1; t<=T; t++)
		{
			N = Integer.parseInt(br.readLine());
			StringTokenizer st ;
			Map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) 
			{
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) 
				{
					Map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count=0;
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					if( Map[i][j] !=0 && visited[i][j] == false )
					{
						count++;	
						bfs( i, j);
					}
				}
			}
			List<Integer> l = new ArrayList<Integer>();
			while( ! q.isEmpty())
			{
				pair  pp = q.poll();
				l.add(pp.x);
				l.add(pp.y);
			}
			
			bw.write("#" + t + " " + count + " ");
			for(int i =0 ; i< l.size();i++)
			{
				bw.write( l.get(i) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}
}
// 크기가 같은 경우에는 행이 작은 순서대로 출력을 한다. 
/*
1
9
1 1 3 2 0 0 0 0 0
3 2 5 2 0 0 0 0 0
2 3 3 1 0 0 0 0 0
0 0 0 0 4 5 5 3 1
1 2 5 0 3 6 4 2 1
2 3 6 0 2 1 1 4 2
0 0 0 0 4 2 3 1 1
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

 */