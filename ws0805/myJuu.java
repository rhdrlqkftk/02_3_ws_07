public class MyJJoo{ // WS_������ �ùķ��̼�
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
		System.out.println("����: -1");
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
				q.add(new Man(number, stock + 1)); // �� ���� ���
				q.add(new Man(++numberCnt, 1)); // ���Ӱ� ���� ���
			}
			System.out.println("������ ������ ���� ���=" + number);
			System.out.println("�� �޾ư� ����=" + Quantity);
		}
		System.out.println("����Ǿ���.");
	}
}