// 정렬 연습하기 좋은 문제다. 
package afternoon;
import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		Meeting[] meets = new Meeting[N];
		for(int n=0; n<N;n++)
		{
			meets[n] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(meets);
		int endT = meets[0].et; // 끝나는 시간이 가장 빠른 회의의 끝나는 시간을 기준으로 잡아놓고. 
		int count = 1; 
		for(int i =1; i < N;i++)
		{
			if( endT <= meets[i].st)
			{
				count ++; 
				endT = meets[i].et; 
			}
		}
		System.out.println(count);
	}
	static class Meeting implements Comparable<Meeting>
	{
		int st, et; 
		Meeting(int s, int e)
		{
			st =s; 
			et =e;
		}
		@Override
		public int compareTo(Meeting o) {
			if( this.et == o.et)
			{
				return this.st - o.st;  //2번째 정렬 기준, 끝난시간이 같다면 시작 시간이 빠른 녀석으로 끝낸다. 
			}
			return this.et - o.et; //1번째 정렬 기준, 끝나는 시간이 빠른 녀석으로 정렬한다. 
		}
	}
}
