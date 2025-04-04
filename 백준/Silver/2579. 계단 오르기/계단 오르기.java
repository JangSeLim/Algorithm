// dp

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 계단의 개수는 300이하의 자연수
		int[] stairs = new int[N + 1]; // 계단에 쓰여 있는 점수는 10,000이하의 자연수
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		} // 입력받기 완료

		int[] dp = new int[N + 1];
		dp[1] = stairs[1];

		// N = 1일수도 있음
		if (N >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	} // main
}
