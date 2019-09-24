import java.util.Scanner;

public class Solution {
	static int n; 
	static int m; 
	static boolean Map[][]; 
	static boolean boundary(int x, int y)
	{
		if(x <0 || y <0 || x >= m || y >= n)
		{
			return false; 
		}
		return true; 
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt(); 
		for(int t =1; t <= Tc; t++)
		{
			n = sc.nextInt();  // 가로
			m = sc.nextInt();  // 세로
			int ans =0; 
			for(int i =0; i <n; i++)
			{
				for(int j =0 ;j <m;j++)
				{
					if( i %4 <2)
					{
						if( j %4 <2)
						{
							ans ++; 							
						}
					}
					else 
					{
						if( j % 4 >=2)
						{
							ans ++;
						}
					}
				}
			}
			System.out.println("#" + t+ " "+ ans);
		}
	}
}
//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWLv-yZah48DFAVV&solveclubId=AWv0G8c6S0wDFASy&problemBoxTitle=%EC%9B%8C%ED%81%AC%EC%83%B5+0924&problemBoxCnt=1&probBoxId=AW1gpNJK9wMDFARC
// 왜 이생각을 못했을까... 자괴감이 느껴지는 문제 