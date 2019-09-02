import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// 0234872
public class Solution4 
{
	static int TC, N;
	static long ans; 
	static Point[] worms;
	static boolean visit[] ;
	
	static void dfs(int idx, int cnt)
	{
		if( cnt == (N/2))
		{
			long tmpx =0 , tmpy =0; 
			for(int i=0; i < N; i++)
			{
				if( visit[i]) // true면
				{
					tmpx -= worms[i].x; 
					tmpy -= worms[i].y;
				}
				else
				{
					tmpx += worms[i].x; 
					tmpy += worms[i].y;
				}
			}
			ans = Math.min(ans, tmpx* tmpx + tmpy*tmpy);
			return;
		}
		/*
		for(int i = idx ;i<N; i++)
		{
			if( !visit[i])
			{
				visit[i] = true; 
				dfs( i+1, cnt+1);
				visit[i] = false; 
			}
		}
		*/
		////////////////////////////////////////////////////////////////
		if( idx >= N)
		{
			return ;
		}
		visit[idx]=true;
		dfs( idx+1 , cnt+1);
		visit[idx]=false;
		dfs( idx+1 , cnt);

	}
	public static void main(String[] args) throws Exception, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t= 1; t<=T; t++)
		{	
			N = Integer.parseInt(br.readLine()); 
			StringTokenizer st; 
			worms = new Point[N];  // N마리의 지렁이.  
			visit = new boolean[N];
			for( int i =0 ; i < N; i++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); 
				int y = Integer.parseInt(st.nextToken()); 
				worms[i] = new Point(x,y);
			}

			ans = Long.MAX_VALUE;
			dfs(0,0);	
			bw.write("#" + t + " " + ans+ "\n"); 
		}
		bw.flush();
		bw.close();
	}
	static class Point
	{
		int x, y; 
		Point(int x1, int y1)
		{
			x =x1; 
			y =y1;
		}
	}
}
