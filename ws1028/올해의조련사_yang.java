package ws1028;
import java.util.Scanner;
public class 올해의조련사_yang {
	static int N; 
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc= 1; tc<= T; tc++)
		{
			N = sc.nextInt(); 
			char[] input = new char[N];
			char[] result = new char[N];
			for(int i=0;i <N ; i++)
			{
				input[i]= sc.next().charAt(0);
			}
			// left , right 위치   
			int left =0; 
			int right = N-1;  
			int rIdx =0;
			while(true)
			{
				if( input[left] <input[right]) // 왼쪽 알파벳 먼저오는 경우
				{
					result[rIdx++] = input[left++];
				}
				else if( input[left] > input[right]) // 오른쪽알파벳 먼저오는 경우
				{
					result[rIdx++] = input[right--];
				}
				else 
				{
					if( left ==right) // 같다면. 
					{
						result[rIdx] = input[left];
						break;
					}
					int tempL = left, tempR = right; 
					while( (tempL < tempR)&& (input[++tempL] == input[--tempR]))
					{
						continue;
					}
					if( tempL == tempR)
					{ 
						result[rIdx++] = input[left++];
					}
					else 
					{
						if( input[tempL] < input[tempR])
						{
							result[rIdx++] = input[left++];
						}	
						else
						{
							result[rIdx++] = input[right--];
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder("#" +tc +" ");
			for( char s : result)
			{
				sb.append(s);
			}
			System.out.println(sb);
					
		}
	}
}
// (first, last) = get, remove, add