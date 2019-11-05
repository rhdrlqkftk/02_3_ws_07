import java.util.Scanner;

public class 정올_오목 {
	// 1은 검은색 
	static int dx[] = {-1,0,1,1}; 
	static int dy[] = { 1,1,1,0}; 
	static int t_dx[] = { 1, 0, -1,-1}; 
	static int t_dy[] = {-1,-1, -1, 0}; 

	static Scanner sc = new Scanner(System.in);
	static int Map[][] = new int[19][19];
	static boolean boundary(int x, int y)
	{
		if( x<0||y<0 || x>=19 || y >=19)
		{
			return false; 
		}
		return true; 
	}
	public static void main(String[] args) 
	{
		int ans=0;
		int lx=0; 
		int ly=0;
		for (int i = 0; i < 19; i++) 
		{
			for (int j = 0; j <19; j++) 
			{
				Map[i][j] = sc.nextInt();
			}
		}
		label:
		for (int i = 0; i < 19; i++) 
		{
			for (int j = 0; j <19; j++) 
			{
				int g = Map[i][j]; // 값을 잡아주고. 
				if (g ==0)continue;
				for(int d =0; d<4;d++)
				{
					int tnx = i +t_dx[d]; 
					int tny = j +t_dy[d]; 
					if( boundary(tnx, tny)) //범위 내에 있으면, 
					{
						if( Map[tnx][tny]== g)
						{
							continue;
						}
					}
					if( chk (d, i, j,g))
					{
						lx =i+1; 
						ly =j+1;
						ans = g ; 
						break label;
					}
				}
			}
		}
		System.out.println(ans);
		if( ans !=0)
		{
			System.out.println(lx + " "+ ly);
		}
		
	}
	static boolean chk( int dir,int x, int y, int color)
	{
		int nx = x; 
		int ny = y; 
		int cnt =0; 
		while(true)
		{
			if(!boundary(nx,ny)) break;
			if(Map[nx][ny] !=color )
			{
				break;
			}
			cnt++; 
			nx += dx[dir];
			ny += dy[dir];
		}
		if( cnt == 5)
		{
			return true;
		}
		else 
		{
			return false;			
		}
	}
}
