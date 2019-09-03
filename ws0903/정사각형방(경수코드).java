import java.util.Scanner;

public class Test {
	static int N, Max, K; 
	static int Map[][] ;
	static int Count[];
	static int dx[] = {0,-1,0,1}; 
	static int dy[] = {-1,0,1,0};
	
	static boolean boundary(int x, int y)
	{
		if( x < 0 || y< 0 || x >= N || y >= N)
		{
			return false;
		}
		return true;
	}
	static int dfs(int x, int y)
	{
		int count=1; 
		for(int i =0 ; i<4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if( !boundary(nx,ny))continue;
			if( Map[nx][ny] ==Map[x][y] +1)
			{
				count += dfs(nx,ny);				
			}
		}
		return count;
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int t =1;t <=T; t++)
		{
			N = sc.nextInt();
			Map = new int[N][N];
			for(int i =0 ; i< N;  i++)
			{
				for(int j =0;j <N; j++)
				{
					Map[i][j] = sc.nextInt();
				}
			}
			Count = new int[N *N +1];
			for(int i =0 ; i< N;  i++)
			{
				for(int j =0;j <N; j++)
				{
					Count[Map[i][j]] =dfs( i,j);
				}
			}
			int st=0;
			for( int i =1 ;i < Count.length;i++)
			{
				if( Count[i]> Count[st])
				{
					st =i;
				}
			}
			System.out.println("#"+ t + " " + st +" " + Count[st]);
		}
	}
	
}
//개쩌는놈.. 
