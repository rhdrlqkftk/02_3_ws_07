public class MyJJoo{ // WS_마이쮸 시뮬레이션
?
	static class Man {
		int number;
		int stock;
?
		Man(int number, int stock) {
			this.number = number;
			this.stock = stock;
		}
	}
?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("종료: -1");
		while (true) {
			int N = sc.nextInt();
			int Quantity = N;
			if (N == -1) {
				break;
			}
?
			Queue<Man> q = new LinkedList<>();
			int number = -1;
			int numberCnt = 1;
			int stock = -1;
?
			q.add(new Man(1, 1));
?
			while (N > 0) {
				number = q.peek().number;
				stock = q.peek().stock;
				q.remove();
				N -= stock;
				q.add(new Man(number, stock + 1)); // 또 들어가는 사람
				q.add(new Man(++numberCnt, 1)); // 새롭게 들어가는 사람
			}
			System.out.println("마지막 마이쮸 받은 사람=" + number);
			System.out.println("총 받아간 갯수=" + Quantity);
		}
		System.out.println("종료되었음.");
	}
}