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
[�Է�]

ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.
�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���� ��ȣ N(1��N��109)�� �־�����.


[���]

�� �׽�Ʈ ���̽����� ��#x��(x�� �׽�Ʈ���̽� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�)�� ����ϰ�,
�� �׽�Ʈ ���̽����� N���� ���� ����, �����ʿ� ���� �� ���ڸ� �������� �����Ͽ� ����Ѵ�.

 */