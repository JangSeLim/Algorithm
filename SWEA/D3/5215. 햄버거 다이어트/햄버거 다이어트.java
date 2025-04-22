import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, L;
	static int[] score, cal;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			score = new int[N]; // 점수
			cal = new int[N]; // 칼로리
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[N + 1][L + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <= L; j++) {
					// i번째 재료를 사용하지 않는 경우
					dp[i][j] = dp[i - 1][j];

					// i번째 재료를 사용할 수 있는 경우
					if (j >= cal[i - 1]) {
						int sel = dp[i - 1][j - cal[i - 1]] + score[i - 1];
						dp[i][j] = Math.max(dp[i][j], sel);
					}
				}
			}

			System.out.println("#" + tc + " " + dp[N][L]);
		} // tc
	} // main

}