import java.util.Scanner;

public class Solution {
	static int N;
	static int K;
	static int Map[][];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Queue<Integer> queue = new LinkedList<>();
		int Test = sc.nextInt();
		for (int T = 1; T <= Test; T++) {
			N = sc.nextInt();
			K = sc.nextInt();
			Map = new int[K][N];
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < K; j++) {
						Map[j][i] = cnt++;
					}
				} else {
					for (int j = K - 1; j >= 0; j--) {
						Map[j][i] = cnt++;
					}
				}
			}
			int sum[] = new int[K+1];
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < N; j++) {
					sum[i+1] += Map[i][j];
				}
			}
			System.out.print("#"+T+ " ");
			for (int i = 0; i < K; i++) 
			{
				System.out.print(sum[i+1]+ " ");
			}
			System.out.println();
		}
	}

}