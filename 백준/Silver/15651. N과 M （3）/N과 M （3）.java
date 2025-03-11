import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		recur(list, 0);
		System.out.println(sb);
	}

	static void recur(ArrayList<Integer> list, int index) {
		// M개의 숫자를 모두 선택한 경우
		if (index == M) {
			// 현재 선택한 숫자 출력
			for (int num : list) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return; // 재귀 종료
		}

		// 1부터 N까지 숫자를 하나씩 선택
		for (int i = 1; i <= N; i++) {
			list.add(i);
			recur(list, index + 1);
			list.remove(list.size() - 1);
		}
	}
}
// 중복순열
