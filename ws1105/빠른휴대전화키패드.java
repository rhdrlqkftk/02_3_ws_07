import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 빠른휴대전화키패드
{
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int T = Integer.parseInt(br.readLine());
		String J[][]= {
				{"1","1","1"},
				{"1","1","1"},
				{"a","b","c"},
				{"d","e","f"},
				{"g","h","i"},
				{"j","k","l"},
				{"m","n","o"},
				{"p","q","r","s"},
				{"t","u","v"},
				{"w","x","y","z"}
		}; 
		for(int tc = 1; tc<=T;tc++)
		{
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken(); //6666
			int N = Integer.parseInt(st.nextToken()); // 3 
			int cnt=0; 
			st = new StringTokenizer(br.readLine()); // tomo mono dak
			for(int i =0; i<N;i++)
			{	
				String word = st.nextToken();
				if( word.length() != s.length())continue;
				boolean jw1 = false; 
				for(int j =0; j<s.length(); j++)//6666 처음껄 넣는다. 
				{
					int idx = Integer.parseInt(s.charAt(j)+"");
					boolean jw = false; 
					for(int z =0;z< J[idx].length;z++) 
					{
						if(J[idx][z].equals(word.charAt(j)+""))
						{
							jw= true; 
						}						
					}
					if( jw == false) // jw가 true여야 맞는것. 
					{
						jw1 = true;
					}
				}
				if( jw1 == false)
				{
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+ cnt);
		}
	}
}
