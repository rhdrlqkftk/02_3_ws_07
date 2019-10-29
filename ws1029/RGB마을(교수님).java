package ws1029;

import java.util.Scanner;

public class RGB���� {
	static int N; 	
	static int price[][];
	static int dp[][];
	// R G B�� �ش� ���� ��, ��, �� �� ĥ���� �� ����� ����. 
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //���� ����. 
		price = new int [N+1][3];
		dp = new int [N+1][3];
		for(int i=1; i <=N; i++)
		{
			for(int j=0;j<3;j++) // 3���߿� �ϳ� ����. 
			{
				price[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1;i <=N; i++) // i�� ���� �ϳ��� ������Ű�鼭 ������ ����س�����.
		{
			for(int j =0;j<3;j++) // ���� i��° ���� j ������ ĥ�ϰ��� �Ѵٸ�?
			{
				int Min = Integer.MAX_VALUE;
				for(int k=0;k <3; k++) // ������ ���� 3���� �� j�� ������ ���� k�� ���鼭 ���� �� ã��.
				{
					if( k!=j && dp[i-1][k] < Min)
					{
						Min = dp[i-1][k];
					}
				}
				// 1 0 = Min(���� ) + price(���簪) 
				dp[i][j] = Min + price[i][j];
			}
		}
		int ans = Math.min(dp[N][0], dp[N][1]);
		ans = Math.min(ans, dp[N][2]);
		System.out.println(ans);
	}
}
