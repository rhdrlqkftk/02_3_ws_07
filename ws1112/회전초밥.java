package ws1112;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전초밥 {
	static boolean chk = false;
	static int N, d, k, c;
	static int sushi[];
	static int l[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		l = new int[N];
		for (int i = 0; i < N; i++) 
		{
			l[i] = Integer.parseInt(br.readLine());
		}
		int Max = 0;
		sushi = new int[d + 1];
		int count = 0;
		sushi[c]++;
		count++;
		for (int i = 0; i < N; i++) // 8번 돌아서 확인해야겠지.
		{
			if(i == 0)
			{
				for (int j = 0; j < k; j++) 
				{
					int tmp = j;
					if (sushi[l[tmp]] == 0) {
						count++;
					}
					sushi[l[tmp]] += 1;
				}
			} 
			else 
			{
				sushi[l[i - 1]] -= 1;
				if (sushi[l[i - 1]] == 0)
				{
					count--;
				}
				int tmp = (k + i - 1) % N;
				if (sushi[l[tmp]] == 0) 
				{
					count++;
				}
				sushi[l[tmp]] += 1;
			}
			if (count > Max) {
				Max = count;
			}
		}
		System.out.println(Max);
	}
}
