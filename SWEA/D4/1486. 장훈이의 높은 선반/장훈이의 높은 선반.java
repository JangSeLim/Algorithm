// 부분집합 dfs

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] staff;
	static int N, B, minDiff;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			staff = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				staff[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(staff));
			minDiff = Integer.MAX_VALUE;
			dfs(0, 0);

			System.out.println("#" + tc + " " + minDiff);
		}
	}

	// 모든 부분집합을 탐색하면서 합이 B 이상인 것 중 최소 차이 찾기
	private static void dfs(int idx, int sum) {
		if (sum >= B) {
			minDiff = Math.min(minDiff, sum - B);
			// 더 이상 탐색할 필요 없음 (가지치기)
			return;
		}
		if (idx == N) return;

		// 현재 직원 포함
		dfs(idx + 1, sum + staff[idx]);
		// 현재 직원 미포함
		dfs(idx + 1, sum);
	}
}
