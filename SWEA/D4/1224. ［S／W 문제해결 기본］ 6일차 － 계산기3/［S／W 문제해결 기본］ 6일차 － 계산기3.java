import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			String str = sc.next();
			
			String res = postfix(str);

			System.out.println("#" + test_case + " " + calc(res));

		}
		sc.close();
	}

	// 후위표기식
	static String postfix(String str) {
		Map<Character, Integer> prior = new HashMap<>();
		prior.put('(', 0);
		prior.put('+', 1);
		prior.put('-', 1);
		prior.put('*', 2);
		prior.put('/', 2);

		StringBuilder sb = new StringBuilder(); // 숫자
		Stack<Character> op = new Stack<>(); // 연산자
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// ( 라면 넣기
			if (c == '(') {
				op.push(c);
			}
			// ) -> (를 만날때까지 pop해
			else if (c == ')') {
				while (!op.isEmpty() && op.peek() != '(') {
					sb.append(op.pop());
				}
				op.pop(); // (제거
			}

			// 숫자
			else if (c >= '0' && c <= '9') {
				sb.append(c);
			}

			// 연산자
			else {
				if (op.isEmpty()) {
					op.push(c);
				} else {
					while (!op.isEmpty() && prior.get(op.peek()) >= prior.get(c)) {
						sb.append(op.pop());
					}
					op.push(c);
				}
			}
		}
		while (!op.isEmpty()) {
			sb.append(op.pop());
		}
		return sb.toString();
	}

	// 후위표기식 계산기
	static int calc(String str) {
		Stack<Integer> numbers = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// 숫자라면 숫자로 stack에 저장
			if (c >= '0' && c <= '9') {
				numbers.push(c - '0');
			}
			// 연산자라면
			else {
				int B = numbers.pop();
				int A = numbers.pop();

				switch (c) {
				case '+':
					numbers.push(A + B);
					break;
				case '-':
					numbers.push(A - B);
					break;
				case '*':
					numbers.push(A * B);
					break;
				case '/':
					numbers.push(A / B);
					break;
				}
			}
		}
		return numbers.pop();
	}
}