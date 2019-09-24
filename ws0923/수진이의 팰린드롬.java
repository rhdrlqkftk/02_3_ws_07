package SWEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static char[] master;
	public static void main(String[] args) throws Exception, IOException 
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		for(int t =1 ; t<=T; t++)
		{	
			String s = new String(br.readLine());
			int arr[] = new int[26];
			int ans =0; 
			
			for(int i=0 ;i <s.length(); i++ )
			{
				arr[s.charAt(i)-'a']++;
			}
			for(int i =0; i < 26; i++)
			{
				ans  += (arr[i]*(arr[i]+1) /2);
			}
			System.out.println("#"+ t + " "+ ans);
		}
		
	}
}
