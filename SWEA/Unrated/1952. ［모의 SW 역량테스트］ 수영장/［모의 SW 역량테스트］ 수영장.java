import java.util.Scanner;

public class Solution {
	static int[] fee; // 요금제
	static int[] swim; // 월 별 이용 계획
	static int min; // 가장 적은 비용

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();

			// 입력 받기
			fee = new int[4];
			for (int i = 0; i < 4; i++) {
				fee[i] = sc.nextInt();
			}
			swim = new int[12];
			for (int i = 0; i < 12; i++) {
				swim[i] = sc.nextInt();
			}

			min = fee[3];
			dfs(0, 0); // 0번째 달부터 시작, 0원부터 시작

			sb.append("#").append(tc).append(" ").append(min);
			System.out.println(sb.toString());
		}
		sc.close();
	}

	static void dfs(int cnt, int sum) {
		// 12개월을 모두 탐색한 경우
		if (cnt >= 12) {
			min = Math.min(min, sum); // 최소 비용 갱신
			return;
		}

		// 1일권을 사용하는 경우
		dfs(cnt + 1, sum + (swim[cnt] * fee[0]));

		// 한 달권을 사용하는 경우
		dfs(cnt + 1, sum + fee[1]);

		// 3개월권을 사용하는 경우 (3개월권을 적용할 수 있다면)
		dfs(cnt + 3, sum + fee[2]);

	}
}
