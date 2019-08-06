import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		for (int Test = 1; Test <= 10; Test++) {
			int idx = 0;
			int cnt = 0;
			ArrayList<String> li = new ArrayList<>();
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				String s = sc.next(); // Line은 띄어쓰기 무시하고
				li.add(s);
			}
			int T = sc.nextInt();
			for (int i = 0; i < T; i++) {
				String r = sc.next();
				char c = r.charAt(0);
				idx = sc.nextInt();
				cnt = sc.nextInt();
				for (int j = 0; j < cnt; j++) {
					String kk = sc.next();
					li.add(idx + j, kk);

				}
			}
			System.out.println("#" + Test + " ");
			for (int g = 0; g < 10; g++) {
				System.out.print(li.get(g) + " ");
			}
			System.out.println();
		}
	}
}