import java.util.Scanner;

public class SW8016 {

	static int T;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] num;
		num = new long[] { 1, 1 };

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			long a1 =System.nanoTime();
			long N = sc.nextLong();
			
			if (N != 1) {
				for (int i = 0; i < 2; i++) {
					num[i] = 2 * (N + i) * (N + i) - 4 * (N + i) + 3;
				}
				num[1] = num[1] - 2;
			}
			System.out.println("#" + t + " " + num[0] + " " + num[1]);
			long b1 =System.nanoTime();
			
			long c1 = (b1-a1)/1000000000; 
			System.out.println(c1);
		}
	}
}



/*
[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 층의 번호 N(1≤N≤109)이 주어진다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
각 테스트 케이스마다 N층의 제일 왼쪽, 오른쪽에 쓰게 될 숫자를 공백으로 구별하여 출력한다.

 */