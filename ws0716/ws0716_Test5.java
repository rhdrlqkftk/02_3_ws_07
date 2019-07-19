package day0716;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			boolean[] check = new boolean[100];
			Arrays.fill(check, false);
			// N ==100까지다.
			for (int i = 1; i <= K; i++) {
				int T = sc.nextInt();
				check[T] = true;
			}
			System.out.print("#"+ t + " ");
			for (int i = 1; i <= N; i++) {
				if (check[i] == false)
				{
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}
}

/*
 * 5 3 2 5 3
 */