package Morning_0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test_array3 {
	static int N, M, R;
	static int[][] arr;
	static String[] str = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		for (int T = 1; T <= Tc; T++) 
		{
			String[] nm = br.readLine().split(" ");
			int N = Integer.parseInt(nm[0]); // 16 80
			int M = Integer.parseInt(nm[1]);
			
			String[] input = new String[N];
			for (int n = 0; n < N; n++) 
			{
				input[n] = br.readLine();
			}
			String code = null;
			for (int n = 0; n < N; n++) 
			{
				boolean isGo = true;
				for (int j = M - 1; j > 55; j--) {
					// 뒤에 끊어내면되겠구나.
					if (input[n].charAt(j) == '1') {
						code = input[n].substring(j - 55, j + 1);
						isGo = false;
						break;
					}
				}
				if (!isGo)
					break;
			}	
			int[] numCode = new int[8];
			// 위에서 찾아낸 56개의 글자를 7갸씩 끊으면 8개의 코드가 나옴.
			for (int i = 0; i < 8; i++) 
			{
				String subCode = code.substring(i * 7, i * 7 + 7);
				// 7개씩 끊어서 뭐할꺼야?
				for (int j = 0; j < str.length; j++) 
				{
					if (subCode.equals(str[j])) 
					{
						numCode[i] = j;
					}
				}
			}
			////////더해줘야겠구나. 
			int sum =0;
			int sum1 =0;
			for (int i = 0; i < 8; i++) 
			{
				if( i%2 ==0)//
				{
	 				sum += numCode[i] * 3;	
				}
				else
				{
					sum += numCode[i];
				}
				sum1 += numCode[i];
			}
			int ans=0;
			if(sum %10 == 0) // 80 ==	
			{
				ans = sum1;
			}
			else
			{
				ans =0;
			}
			System.out.println("#" +T+ " "+ ans);
		}
	}
}

