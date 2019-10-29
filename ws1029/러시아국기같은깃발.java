package ws1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 러시아국기같은깃발 {
	static int N, M ,ans,  Min; 
	static char Map[][],TMap[][];
	public static void main(String[] args) throws Exception, IOException 
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); 
		for(int tc= 1; tc<=T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken()); 
			Map = new char[N][M];
			TMap = new char[N][M];
			for(int i =0 ; i< N; i++)
			{
				String s = br.readLine();
				for(int j=0;j< M; j++)
				{
					Map[i][j] =s.charAt(j);
					TMap[i][j]=Map[i][j];
				}
			}
			ans =0;
			for(int j=0;j< M; j++)
			{
				if(Map[0][j] != 'W')
				{
					ans++; 
					Map[0][j] ='W';
				}
			}
			for(int j=0;j< M; j++)
			{
				if(Map[N-1][j] != 'R')
				{
					ans++; 
					Map[N-1][j] ='R';
				}
			}
			System.out.println(ans);
			Min = Integer.MAX_VALUE;
			dfs(1,0,0,1);
			
			// 기본으로 바꿔두고 시작하자. 
			// 이제 순서는 흰-> 파 -> 빨 
			// 흰색, 빨은 들어와도 되고 안들어도 되고. 
			// 파란색은 무조건 들어와야한다. 
			// 흰 빨 파 ( 1,2,3으로 둘까 일단 )
			System.out.println("#"+tc+" "+ Min);
		}
	}
	static void dfs(int w,int b, int r, int cnt )
	{
		if( cnt == N-1 )
		{
			if( w ==0 || b==0 )return;
			if( w+b+r != N-1)
			{
				return; // 꺼져. 
			}
			if( Min > ans)
			{
				Min = ans; 
			}
			return ; 
		}
		// 흰색으로 가는경우. 
		if( b==0 && r ==0 && cnt <N-2)
		{
			int ttt=0;
			for(int j=0;j< M; j++)
			{
				if(Map[cnt][j] != 'W')
				{
					ttt++; 
					Map[cnt][j] ='W';
				}
			}
			ans += ttt; 
			dfs(w+1, b,r,cnt+1);
			ans -= ttt;
			for(int j=0;j< M; j++)
			{
				Map[cnt][j] =TMap[cnt][j];
				
			}
		} // b로가는경우.
		if( r == 0 && cnt <N-1)
		{
			int ttt =0;
			for(int j=0;j< M; j++)
			{
				if(Map[cnt][j] != 'B')
				{
					ttt++; 
					Map[cnt][j] ='B';
				}
			}
			ans += ttt; 
			dfs(w, b+1,r,cnt+1);
			ans -= ttt;
			for(int j=0;j< M; j++)
			{
				Map[cnt][j] =TMap[cnt][j];			
			}
		}
		if(b !=0)
		{
			int ttt =0;
			for(int j=0;j< M; j++)
			{
				if(Map[cnt][j] != 'R')
				{
					ttt++; 
					Map[cnt][j] ='R';
				}
			}
			ans += ttt; 
			dfs(w, b,r+1,cnt+1);
			ans -= ttt;
			for(int j=0;j< M; j++)
			{
				Map[cnt][j] =TMap[cnt][j];			
			}
		}
		
	}
	
	static void chk()
	{
		for(int i =0 ; i< N; i++)
		{
			for(int j=0;j< M; j++)
			{
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
