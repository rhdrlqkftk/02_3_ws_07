import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution{
    static Scanner sc = new Scanner(System.in);
    static int N;
 
    static int sum = 0;
 
    static Queue<String> q1 = new LinkedList<>();
    static Queue<String> q2 = new LinkedList<>();
    static Queue<String> q3 = new LinkedList<>();   
 
    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int test = 1; test <= T; test++) 
        {
            N = sc.nextInt(); 
            int G = N/2;   
            // N== 5라면, G == 2가 되고,  0, 1, 2 / 3,4
            for(int i=0 ; i<N; i++)
            {
                String s = sc.next(); 
                if( N%2 == 0)
                {
                    if( i<G)
                    {
                        q1.add(s);
                    }
                    else
                    {
                        q2.add(s);
                    }
                }
                else
                {
                    if( i<=G)
                    {
                        q1.add(s);
                    }
                    else
                    {
                        q2.add(s);
                    }       
                }
            }
            while(true)
            {
                boolean x = false; 
                boolean y = false;
                if( !q1.isEmpty())
                {
                    q3.add(q1.poll());
                    x= true;
                }
                if( !q2.isEmpty())
                {
                    q3.add(q2.poll());
                    y = true; 
                }
                if( x ==false && y == false)
                {
                    break;
                }
            }
            System.out.print("#" + test+ " ");
            while(!q3.isEmpty())
            {
                System.out.print(q3.poll()+" ");                        
            }
            System.out.println();
        }
    }
}