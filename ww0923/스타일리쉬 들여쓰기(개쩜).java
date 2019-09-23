package SWEX;
import java.util.Arrays;
import java.util.Scanner;
public class Solution2 
{
	static int p, q; 
	static char[][] master; // 마스터의 코드
	static char[][] me; // 나의 코드	
	static int[]  result;  // 내 코드 각 줄에 진행해야하는 들여쓰기 수.
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt(); 
		for(int t = 1; t <= Tc; t++)
		{
			p = sc.nextInt();  // master line
			q = sc.nextInt();  // me line
			//
			master = new char[p][]; //뒤에 안쓰면 고정되어있지 않게 쓸 수 있다.길이 유동적 . 
			me = new char[q][];
			
			result = new int[q]; 
			Arrays.fill( result, -2); // 아직 기록되지않은 상태를 -2 
			// 후에 계산되는 들여쓰기 갯수에 따라 0 or -1 등의 값이 기록됨. 
			for(int i =0; i<p; i++) // 마스터의 코드 p줄 입력. 
			{
				master[i] = sc.next().toCharArray(); 
			}
			for(int i =0 ; i<q; i++)
			{
				me[i] = sc.next().toCharArray();
			}
			// 가능한 r,c,s를 다만들어본다.
			for(int r = 1; r <=20; r++)
			{
				for(int c = 1; c <=20; c++)
				{
					for(int s = 1; s <=20; s++)
					{
						if(isOK(r,c,s)) /// 맞는 RCS인지 확인하기. 
 						{
							useRCS(r,c,s);
						}
					}
				}
			}
			System.out.print("#" + t + " ");
			for(int k :result)
			{
				System.out.print(k+" ");
			}
			System.out.println();
		}
	}
	static boolean isOK(int r, int c, int s)
	{
		int rCnt = 0; 
		int cCnt = 0; 
		int sCnt = 0;
		for(int i=0; i <p; i++)
		{
			int dotCnt=0;
			for( int j =0;  j< master[i].length; j++)
			{
				if( master[i][j]=='.')
				{
					dotCnt++; 	
				}
				else 
				{
					break;
				}
			}// i번 행의 들여쓰기 갯수를 카운트 함.
			
			int tab = r*rCnt + c*cCnt + s*sCnt; 
			if( tab != dotCnt)
			{
				return false; 
			}
			for(int j=0; j< master[i].length; j++)
			{
				switch(master[i][j])
				{
					case '(' : rCnt++; break;
					case ')' : rCnt--; break;
					case '{' : cCnt++; break;
					case '}' : cCnt--; break;
					case '[' : sCnt++; break;
					case ']' : sCnt--; break;
				
				}
			}
		}
		return true; 
	}
	static void useRCS(int r , int c , int s)
	{
		int rCnt = 0, cCnt = 0, sCnt = 0;
		for(int i =0 ; i<q; i++)
		{
			if( result[i] == -2) // 처음이네? 
			{
				result[i] =  r*rCnt + c*cCnt + s*sCnt; 
			}
			else // 처음이 아니네?  
			{
				if( result[i]  != ( r*rCnt + c*cCnt + s*sCnt))
				{
					result[i] = -1;
				}
			}
			for(int j=0; j< me[i].length; j++)
			{
				switch(me[i][j])
				{
					case '(' : rCnt++; break;
					case ')' : rCnt--; break;
					case '{' : cCnt++; break;
					case '}' : cCnt--; break;
					case '[' : sCnt++; break;
					case ']' : sCnt--; break;
				}
			}
		}
	}
}
/*
[입력]
1
5 4
(Follow.my.style
.........starting.from.round.brackets)
{then.curly.brackets
.....[.and.finally
.......square.brackets.]}
(Thank.you
{for.showing.me
[all
the.secrets]})
4 2
(This.time.I.will.show.you
.........(how.to.use.round.brackets)
.........[but.not.about.square.brackets]
.........{nor.curly.brackets})
(I.learned
how.to.use.round.brackets)
[출력]
1 0 9 14 16

*/