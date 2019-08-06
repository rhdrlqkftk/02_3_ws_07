package solution;

import java.awt.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class joshepis {
	static Scanner sc = new Scanner(System.in);
	static int N; 
	static int K; 
	
	public static void main(String[] args) {
		ArrayList<Integer> pp = new ArrayList<>();
		ArrayList<Integer> dd = new ArrayList<>();
		N = sc.nextInt(); 
		K = sc.nextInt();  
		// 7, 3 
		for( int i =1 ; i <= N; i++)
		{
			pp.add(i);
		}
		int dc=0;
		int cnt=0;
		while(!pp.isEmpty())
		{
			if(pp.size() == dc) dc %= pp.size();
			dc++;
			cnt++;
			if(cnt == K)
			{
				cnt =0; 
				dc-= 1;
				int c = pp.remove(dc);
				dd.add(c);
			}
			
		
		}
		System.out.print("<");
		int tt = dd.size()-1;
		for( int i =0 ; i< tt; i++)
		{
			System.out.print(dd.get(i)+ ", ");
		}
		System.out.println(dd.get(tt)+">");
		
	}
}
