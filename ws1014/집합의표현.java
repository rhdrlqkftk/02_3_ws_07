package ssafy1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//유니온 파인드 
public class 집합의표현 {
	static int N, M;
	static int arr[];
	static int find(int a)
	{
		if(arr[a] == a)
		{
			return a; //같으면 자기 자신 출력해주면되고 . 
		}
		arr[a] = find(arr[a]);// 왜 해줘야하지? 이렇게 안해주면 매번 재귀를 계속 돌게 된다. 
		return arr[a]; 
	}
	static void union(int a, int b)
	{
		int a1 = find(a);// 부모를 찾는다. 
		int b1 = find(b);
		if( a1 != b1)
		{
			arr[a1] = b1; 
		}
	}
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for(int i =0; i<=N;i++)
		{
			arr[i] =i; // 자기 자신을 부모로 가지고 있는다.일단. 
		}
		int n=0 ,a=0,b=0;
		for(int i =0 ; i< M; i++)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if( n == 0 ) // 합친다.
			{
				union( a,b);
			}
			else if( n == 1)// 확인한다. 
			{
				if(find(a) == find(b))
				{
					System.out.println("YES");
				}
				else 
				{
					System.out.println("NO");					
				}
			}
		}
	}
}
