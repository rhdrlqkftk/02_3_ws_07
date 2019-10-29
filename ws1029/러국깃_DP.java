package ws1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//DP정리. 
public class 러국깃_DP {
	static int N, M ,ans, Min; 
	static int W[], B[], R[]; 
	
	static char Map[][];
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
			
			W = new int[N]; 
			B = new int[N]; 
			R = new int[N]; 
			
			for(int i =0 ; i< N; i++)
			{
				String s = br.readLine();
				for(int j=0;j< M; j++)
				{
					if( s.charAt(j) == 'W')
					{
						B[i]++; 
						R[i]++;
					}
					else if(s.charAt(j) == 'B')
					{
						W[i]++; 
						R[i]++; 
					}
					else if(s.charAt(j) == 'R')
					{
						B[i]++; 
						W[i]++;
					}
				}
			}
			int [][] dp = new int[N][3]; 
			dp[0][0] = W[0]; 
			dp[0][1] = Integer.MAX_VALUE;
			dp[0][2] = Integer.MAX_VALUE;
				
			dp[1][0] = dp[0][0] + W[1]; 
			dp[1][1] = dp[0][0] + B[1]; 
			dp[1][2] = Integer.MAX_VALUE;
			
			for(int i=2 ; i<N; i++)
			{
				dp[i][0] =dp[i-1][0] +W[i]; // 흰색으로 계속 만드는 경우. 
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) +B[i];
				dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) +R[i]; 
			}
			System.out.println("#"+tc+" "+ dp[N-1][2]);
		}
	}
}