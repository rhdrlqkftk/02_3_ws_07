package ssafy1002;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
//무엇을 물어보는 문제인가? 
import java.util.Scanner;
import java.util.StringTokenizer;

public class 입국심사 {
	static int N, M,K; 
	static int min; 
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		StringTokenizer st =null;
		for(int tc=1; tc<=T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 심사대 갯수
			M = Integer.parseInt(st.nextToken()); // 사람 수 .
			int [] times = new int[N]; // 시간 어레이 
			min = Integer.MAX_VALUE;
			for(int i=0; i < N; i++)
			{
				times[i] = Integer.parseInt(br.readLine());  // 심사대 갯수별 걸리는 시간. 
				min = Math.min(min,times[i]); // 최대값을 저장한다. 
			}
			long left =1; 
			long right = min *(long)M ; // 최대 걸리는 시간. 
			//사람 수 * max 를 한 것이 제일 오른 쪽이니까? 
			long total=0, mid =0;  
			while( left <= right)
			{
				mid = (left +right)/2;  // 미드보다 작게 걸리나?  
				total =0 ; 
				for(int k =0 ; k <N; k++) //심사대 갯수. 
 				{
					total += mid/times[k]; ///total은 처리할 수 있는 사람 수를 의미한다. 
					// 이게 M보다 크면 줄여야겠지. 
					if( total > M )
					{
						break;
					}
				}
				if( total < M) // total이 사람수 보다 작을 때! 
				{
					left = mid +1;
				}
				else // 클 때. 
				{
					right = mid -1; 
				}
			}
			System.out.println("#" +tc + " " + left); // 모든사람이 통과하는 최소값. 
		}

	}
}



/*
문제 링크 
https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AWv0G8c6S0wDFASy&contestProbId=AV_XEokaAEcDFAX7&probBoxId=AW2Aqon6e48DFASu&type=PROBLEM&problemBoxTitle=%EC%9B%8C%ED%81%AC%EC%83%B5+0930&problemBoxCnt=1
[입력]
2
2 6
7
10
7 10
3
8
3
6
9
2
4
[출력]
#1 28 //Test Case 1의 답
#2 8  //Test Case 2의 답 

 */