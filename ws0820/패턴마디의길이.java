import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution 
{
    static String arr[];
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t =1 ; t<=T; t++)
        {
            st = new StringTokenizer(br.readLine()); // 30자 들어온다. 
            arr = new String[30]; 
            String s = st.nextToken();
            char ch = s.charAt(0);
            for(int i =0 ; i< s.length(); i++)
            {
                arr[i] = s.charAt(i)+"";
            }
            for(int i =1 ; i< arr.length; i++)
            {
                if( arr[i].equals(ch+""))
                {
                    if(comp(i))
                    {
                        System.out.println("#" + t + " " + i);
                        break;
                    }
                }
            }
        }
    }
    static boolean comp(int index)
    {
        int a =0;
        int b = index;
        while(a < index )
        {
            if( !arr[a].equals(arr[b]) )
            {
                return false;
            }           
            a++; 
            b++;
        }
        return true; 
    }
}