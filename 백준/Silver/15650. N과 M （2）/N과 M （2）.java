import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M + 1];
		visited = new boolean[N + 1];

		recur(0);
	}

	static void recur(int index) {
		// M개의 숫자를 모두 선택한 경우
		if (index == M) {
			// 현재 선택한 숫자 출력
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return; // 재귀 종료
		}
		// 1부터 N까지 숫자를 하나씩 선택
		for (int i = 1; i <= N; i++) {
			// 아직 사용되지 않은 숫자인 경우
			if (!visited[i]) {
				visited[i] = true; // 숫자 사용 표시
				arr[index] = i; // 선택한 숫자를 배열에 저장
				recur(index + 1); // 다음 단계로 재귀 호출
				// i보다 큰 수부터 false처리
				for (int j = i + 1; j <= N; j++) {
					visited[j] = false; // 백트래킹: 원상 복구
				}
			}
		}
	}
}
