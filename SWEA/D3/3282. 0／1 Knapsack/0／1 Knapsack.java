
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 물건의 개수
			int K = Integer.parseInt(st.nextToken()); // 가방의 부피

			int[] volumns = new int[N + 1]; // 물건의 부피 배열
			int[] values = new int[N + 1]; // 물건의 가치 배열
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				volumns[i] = Integer.parseInt(st.nextToken());
				values[i] = Integer.parseInt(st.nextToken());
			} // 입력 완료

			int[][] dp = new int[N + 1][K + 1];

			for (int i = 1; i <= N; i++) {  // i번째 물건까지 고려
				for (int v = 0; v <= K; v++) { // 가방의 현재 부피(v)에 따라 탐색
					if (volumns[i] <= v) { // i번째 물건을 넣을 수 있는 경우
						// 1. i번째 물건을 넣지 않는 경우 (dp[i-1][v])
						// 2. i번째 물건을 넣는 경우 (dp[i-1][v - volumns[i]] + values[i])
						// 두 가지 중 더 큰 값을 선택하여 저장
						dp[i][v] = Math.max(dp[i - 1][v], dp[i - 1][v - volumns[i]] + values[i]);
					} else {
						// i번째 물건을 넣을 수 없는 경우 이전 값 그대로 유지
						dp[i][v] = dp[i - 1][v];
					}
				}
			} // 물건
			System.out.println("#" + tc + " " + dp[N][K]);

		} // tc

	} // main
}
