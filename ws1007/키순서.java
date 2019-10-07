package ssafy1007;
import java.util.Scanner;
// 해쉬맵 
// dfs
// 플로이드 와샬 
public class 키순서 {
	static int map[][] ;
	static int count[]; 
	static boolean visit[]; 
	static int N, M; 
	static void dfs_up(int start, int curr)
	{
		for(int i =0; i < N; i++)
		{
			if(map[curr][i] == 1 && !visit[i])
			{
				visit[i] = true; 
				count[start]++; 
				dfs_up(start, i);
			}
		}
	}
	static void dfs_down(int start, int curr)
	{
		for(int i =0; i < N; i++)
		{
			if(map[i][curr] == 1 && !visit[i])
			{
				visit[i] = true; 
				count[start]++; 
				dfs_down(start, i);
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int tc =sc.nextInt(); 
		for(int T = 1; T<=tc; T++)
		{
			N = sc.nextInt(); // 학생수 
			M = sc.nextInt(); // 비교 횟수.

			map = new int[N][N]; // 순위.
			count = new int[N];
			
			for(int i=0;i < M; i++) // 앞에가 뒤에 보다 작다는 것을 의미한다. 
			{
				int a = sc.nextInt(); 
				int b = sc.nextInt();
				map[a][b] = 1; 
			}
			
			for(int i =0; i< N; i++)
			{
				visit = new boolean[N];
				dfs_up(i, 0);
				visit = new boolean[N];
				dfs_down(i,0);
			}
			for(int i =0 ; i< M; i++)
			{
				
			}
			System.out.println("#"+T + " " + 1);
		}
		
	}

}
/*
● 1번 학생의 키 < 5번 학생의 키
● 3번 학생의 키 < 4번 학생의 키
● 5번 학생의 키 < 4번 학생의 키
● 4번 학생의 키 < 2번 학생의 키
● 4번 학생의 키 < 6번 학생의 키
● 5번 학생의 키 < 2번 학생의 키
*/
//w 자신의 키를 알수 있는 학생은 몇명인지...? 흠... 