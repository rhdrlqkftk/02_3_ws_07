import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
 
public class Solution {
    static int N , M , Min; 
    static int Map[][]; 
    static boolean arr[]; 
     
    static int sum()
    {
        int a = 0; 
        int b = 0;
     
        for(int i =0; i <N; i++)
        {
            for(int j =i+1; j <N; j++)
            {
                if(arr[i] ==arr[j] )
                {
                    if( arr[j] ==true)
                    {                       
                        a +=  Map[i][j] + Map[j][i];
        //              System.out.println("a : "+ a +", " + Map[i][j] +" " + Map[j][i]);
                    }
                    else
                    {
                        b +=  Map[i][j] + Map[j][i];
        //              System.out.println("b :"+ b+ ", " +  Map[i][j] +" " + Map[j][i]);
                    }
                }
            }
        }
        int res = Math.abs( a- b);
        return res; 
    }
    static void select( int cnt, int idx)
    {
        if( cnt == N/2)
        {
            int res = sum();
            if( res <Min)
            {
                Min = res; 
            }
            return ;
        }
        if( idx >= N)
        {
            return ; 
        }
         
        arr[idx] = true; 
        select(cnt+1 , idx+1);
        arr[idx] = false;
        select(cnt, idx+1);
         
    }
    public static void main(String[] args) throws Exception, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++)
        {
            N =Integer.parseInt(br.readLine()); 
            Min = Integer.MAX_VALUE; 
            Map = new int[N][N];
            arr = new boolean[N];
            StringTokenizer st = null;
            for (int i = 0; i < N; i++) 
            {
                st= new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) 
                {                   
                    Map[i][j] = Integer.parseInt(st.nextToken());
                }
            }           
         
            select (0,0);
            bw.write("#"+t+" "+ Min + "\n");
        }
        bw.flush();
        bw.close(); 
    }
}