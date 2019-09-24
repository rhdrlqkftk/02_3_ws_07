package SWEX;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution3 
{
	public static void main(String[] args) throws Exception, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	
		int arr[] = new int [N];
		StringTokenizer st = null; 
	
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<N ;j++)
		{
			arr[j] = Integer.parseInt(st.nextToken());
		}	
		//y하나를 이용해서 하는게 편하다 . 어짜피 오름차순을 비교하는 것이기 때문에. 
		int y =arr.length-2; 
		while(y>= 0 && arr[y] <= arr[y+1])
		{
			y--;
		}
		if( y==-1)
		{
			System.out.println(-1);
			return ; 
		}
		else //	
		{
			int x = arr.length-1;
			swap (arr,y,x);
		}
		int start = y+1; 
		int end = arr.length-1; 
		while(start < end)
		{
			swap(arr , start++ , end--);
		}
		for(int i =0 ; i< N; i++)
		{
			System.out.print( arr[i] + " ");
		}
	}
	static void swap ( int ar[] , int a, int b)
	{
		int tmp = ar[a];
		ar[a] = ar[b];
		ar[b] = tmp; 
	}
}