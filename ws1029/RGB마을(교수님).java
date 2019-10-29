package ws1029;

import java.util.Scanner;

public class RGB마을 {
	static int N; 	
	static int price[][];
	static int dp[][];
	// R G B는 해당 집에 빨, 녹, 파 를 칠했을 때 비용을 말함. 
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //집의 갯수. 
		price = new int [N+1][3];
		dp = new int [N+1][3];
		for(int i=1; i <=N; i++)
		{
			for(int j=0;j<3;j++) // 3개중에 하나 색깔. 
			{
				price[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1;i <=N; i++) // i번 집들 하나씩 증가시키면서 누적값 계산해나가기.
		{
			for(int j =0;j<3;j++) // 현재 i번째 집에 j 색상을 칠하고자 한다면?
			{
				int Min = Integer.MAX_VALUE;
				for(int k=0;k <3; k++) // 앞집의 색상 3가지 중 j를 제외한 색상 k를 보면서 작은 값 찾기.
				{
					if( k!=j && dp[i-1][k] < Min)
					{
						Min = dp[i-1][k];
					}
				}
				// 1 0 = Min(전값 ) + price(현재값) 
				dp[i][j] = Min + price[i][j];
			}
		}
		int ans = Math.min(dp[N][0], dp[N][1]);
		ans = Math.min(ans, dp[N][2]);
		System.out.println(ans);
	}
}
