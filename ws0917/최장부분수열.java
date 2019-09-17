// 최장증가 부분 수열. (LIS)
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Solution{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        for(int t =1 ; t<= T; t++)
        {
            long arr[] = new long[1000];
            int DP[] = new int[1000]; 
             
            int N = sc.nextInt();
            int ans =0; 
            for(int i =0; i< N; i++)
            {
                arr[i] = sc.nextLong();
                int dd =0; 
                for(int j = 0;  j< i; j++)
                {
                    if( arr[i] > arr[j])
                    {
                        dd = Math.max(dd, DP[j]);
                    }
                }
                DP[i] = dd +1;
                ans= Math.max( ans,  DP[i]);
            }
                         
            System.out.println("#"+t+" "+ans);
        }
    }
 
}