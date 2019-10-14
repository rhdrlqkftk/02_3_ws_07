package ssafy1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//유니온 파인드 
public class 나는개구리로소이다 {
	static int N, M;
	static int croak[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = new String();
			int ans = -1;
			s = br.readLine();
			char k = ' ';
			croak = new int[5];
			int croak1 = 0;
			int max = 0;
			boolean ck = false;
			for (int i = 0; i < s.length(); i++) {
				k = s.charAt(i);
				if (k == 'c') {
					croak[0]++;
					croak1++;
				} else if (k == 'r') {
					if (croak[0] <= croak[1]) {
						ck = true;
						break;
					}
					croak[1]++;
				} else if (k == 'o') {
					if (croak[1] <= croak[2]) {
						ck = true;
						break;
					}
					croak[2]++;
				} else if (k == 'a') {
					if (croak[2] <= croak[3]) {
						ck = true;
						break;
					}
					croak[3]++;
				} else if (k == 'k') {
					if (croak[3] <= croak[4]) {
						ck = true;
						break;
					}
					croak[4]++;
					if (croak1 > max) {
						max = croak1;
					}
					croak1--; // 초기화를 0으로 하면 안되네.. 
					//내가 틀린 부분이다. croak1 =0으로 초기화를 했다.. 그러면 절대안되지.. 
					// 하나를 빼줘야하지 바보야..
				}
			}

			boolean chk = false;
			if (ck == false) {
				if (croak[0] == croak[1] && croak[0] == croak[2] && croak[0] == croak[3] && croak[0] == croak[4]) {
					chk = true;
				}
			}
			if (chk == true) {
				System.out.println("#" + tc + " " + max);
			} else if (chk == false) {
				System.out.println("#" + tc + " " + -1);
			}

		}
	}
}
