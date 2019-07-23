import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
	
	static int[] arr;
	static int N; 
	static int binarySearch(int start, int end , int key)
	{
		int ans =0; 
		int left = start; 
		int right = end; 
		while(left<=right )
		{
			int mid = (right + left )/ 2; 
			
			if( arr[mid]==key)
			{
				return 1; 
			}
			else if( arr[mid] > key)
			{
				right = mid - 1;
			}
			else
			{
				left = mid +1; 	
			}
		}
		
		return ans; 
	}

	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();  
		arr = new int[N];
		for(int i =0 ; i < N ;i ++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
	
		int D = sc.nextInt(); 
		int k =0;
		for( int i = 0 ; i< D;i ++)
		{
			k = sc.nextInt();
			int c =binarySearch(0,N-1, k);
			System.out.print( c + " " );
		}
	}

}