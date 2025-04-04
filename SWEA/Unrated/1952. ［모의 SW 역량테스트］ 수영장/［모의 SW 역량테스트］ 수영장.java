import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int threeMonths = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] annual = new int[13];
			for (int i = 1; i <= 12; i++) {
				annual[i] = Integer.parseInt(st.nextToken());
			} // 월별 입력

			int[] dp = new int[13];

			for (int i = 1; i <= 12; i++) {
				// 1일권
				dp[i] = dp[i - 1] + annual[i] * day; 
				// 1달권
				dp[i] = Math.min(dp[i], dp[i - 1] + month);
				// 3달권
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + threeMonths);
				}
				// 1년권
				if (i == 12) {
					dp[i] = Math.min(dp[i], dp[i - 12] + year);
				}
			}
//			System.out.println(Arrays.toString(dp));
			System.out.println("#" + tc + " " + dp[12]);
		} // tc
	} // main
}
