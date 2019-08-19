//베이비 진. 
package afternoon;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // 6자리 수를 입력 받는다. 
		int c[]= new int[12];
		int run=0 , triple=0 ; 
		for(int i =0 ; i <6 ; i++)
		{
			c[N%10] = c[N%10] +1;
			N = N/10;
		}
		int i =0;
		while( i<10)
		{
			if( c[i] >=3)
			{
				c[i] = c[i]-3; 
				triple++;
				continue;
			}
			if( c[i] >= 1 &&  c[i+1] >= 1 && c[i+2] >= 1)
			{
				c[i] = c[i] -1; 
				c[i+1]  =c[i+1]-1;
				c[i+2]  =c[i+2]-1;
				run++;
				continue;
			}
			i++;
		}
		System.out.println( "triple : "+ triple  + " run : "+ run);
	}
}
