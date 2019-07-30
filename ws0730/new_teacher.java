package ws0730;
import java.util.Scanner;
import java.util.Stack;
public class new_teacher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int len = sc.nextInt();
			String input = sc.next();
			// infix 로 작성된 중위표기 수식 입력받음
			String postfix = "";
			Stack<Character> op_stack = new Stack<>();
			for (int i = 0; i < len; i++) {
				char ch = input.charAt(i);
				// 중위표기실에서 한글자 떼서
				if (ch >= '0' && ch <= '9') {
					// 중위표기식에서의 숫자는 바로 후위표기에 갖다 붙이기
					postfix += ch;
				} else if (ch == ')') {
					// 닫히는 괄호인 경우
					char tmp;
					// 스택에서 열리는 괄호가 나올때까지 계속 pop해서 postfix에 붙이기
					while ((tmp = op_stack.pop()) != '(') {
						postfix += tmp;
					}
				} else if (ch == '(') {
					// 열리는 괄호는 무조건 스택에 들어감
					op_stack.push(ch);
				} else {
					// +,-,*,/ 연산자인 경우
					while (!op_stack.isEmpty() && getPriority(op_stack.peek()) >= getPriority(ch)) {
						postfix += op_stack.pop();
					}
					op_stack.push(ch);
				}
			}
			while (!op_stack.isEmpty()) {
				// stack에 연산자가 남아있으면 꺼내서 postfix에 붙여버리면 됨
				postfix += op_stack.pop();
			}
			//			System.out.println(postfix); //postfix 완성!
			Stack<Integer> num_stack = new Stack<>();
			for (int i = 0; i < postfix.length(); i++) {
				char ch = postfix.charAt(i);
				if (ch >= '0' && ch <= '9') {
					// 계산할때 후위표기식의 숫자는 무조건 스택에 푸시!
					num_stack.push(ch - '0');
				} else {
					// 후위표기식에서 숫자 아니었으면 무조건 연산자
					int n1 = num_stack.pop();
					// 스택에서 숫자 두개 꺼내서
					int n2 = num_stack.pop();
					switch (ch) {
						// 해당 연산을 수행한 다음에 스택에 넣음. 다음 연산에 사용되거나 결과값이 된다.
						case '+':
							num_stack.push(n1 + n2);
							break;
						case '*':
							num_stack.push(n1 * n2);
							break;
						case '-':
							num_stack.push(n1 - n2);
							break;
						case '/':
							num_stack.push(n1 / n2);
							break;
					}
				}
			}
			System.out.println("#" + t + " " + num_stack.pop());
		}
	}
	static int getPriority(char op) {
		if (op == '*' || op == '/')
					return 2; else if (op == '+' || op == '-')
					return 1; else if (op == '(')
					return 0; else
					return -1;
	}
}