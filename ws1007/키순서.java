package ws1009;

import java.util.Arrays;
import java.util.Scanner;

public class 키순서 {
	// 플로이드 와샬로 해결한다면 ~? 
	static int N,M, Map[][],Map1[][]; 
	static int chk[], chk1[];
	static boolean ch[]; 
	static boolean ch1[]; 
	// 두번 겹치는경우는 빼줘야할 꺼 같은데 흠.. 
	static void dfs_up ( int origin, int start)
	{
		for(int i =1 ; i <=N; i++)
		{
			if( Map[start][i] ==1) // 작은경우
			{
				if( ch[i] == false)
				{
					chk[origin]++;
					ch[i] = true;
					dfs_up(origin, i);					
				}
			}
		}
		return ; 
	}
	static void dfs_down (int origin, int start)
	{
		for(int i =1 ; i <=N; i++)
		{
			if( Map1[start][i] ==1) //큰경우.
			{
				if( ch1[i] == false)
				{
					ch1[i]= true;
					chk1[origin]++;
					dfs_down(origin, i);
				}
			}
		}
		return ; 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc = 1 ; tc<= T; tc++)
		{
			N = sc.nextInt();  // 사람수
			M = sc.nextInt();  // 비교 횟수를 의미한다. 
			Map  = new int[N+1][N+1];
			Map1  = new int[N+1][N+1];
			chk  = new int [N+1]; 
			chk1 = new int [N+1];
			ch = new boolean[N+1];
			ch1 = new boolean[N+1];
			for(int i =0 ; i <M;i++)
			{
				int a = sc.nextInt(); 
				int b = sc.nextInt(); 
				Map[a][b] =1; // a< b 인경우.
				Map1[b][a] =1; // 앞에 꺼가 더 큰 경우. 
			}
			for(int i =1; i<= N; i++)
			{
				Arrays.fill(ch, false);
				Arrays.fill(ch1, false);
				dfs_up( i,i);
				dfs_down( i,i);
			}
			int cnt=0;
			for(int i=1; i <= N; i++)
			{
				int k = chk[i] + chk1[i];
				if(k == N-1)
				{
					cnt++;
				}
			}
			System.out.println("#"+ tc+ " " + cnt);
		}
	}
}
/*
● 1번 학생의 키 < 5번 학생의 키
● 3번 학생의 키 < 4번 학생의 키
● 5번 학생의 키 < 4번 학생의 키
● 4번 학생의 키 < 2번 학생의 키
● 4번 학생의 키 < 6번 학생의 키
● 5번 학생의 키 < 2번 학생의 키*/