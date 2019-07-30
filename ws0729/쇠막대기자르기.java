package ws0730;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int sum;
	static int con;
	static String line;

	public static void main(String[] args) 
	{
       Scanner sc = new Scanner(System.in);
       int T = sc.nextInt();
       for(int t = 1; t <= T; t++) 
       {
    	   Stack<Character> stack = new Stack<>();
           line = sc.next();
           sum = 0;
           con = 0;
           for (int i = 0; i < line.length(); i++) 
   			{
        	   if(line.charAt(i)== '(') // 몇개 쌓이는지 기록 하기. 
   				{
        		   stack.push(line.charAt(i));
   				}
        	   else 
        	   {
        		   if(line.charAt(i-1)== '(')
      				{
        			   con += (stack.size()-1);  			   
      				}
        		   else 
        		   {	
        			   con +=1; 
        			
        		   }
        		   stack.pop(); 
        	   }
   			} 	
             System.out.println("#" + t + " " + con );
       }
	}
}