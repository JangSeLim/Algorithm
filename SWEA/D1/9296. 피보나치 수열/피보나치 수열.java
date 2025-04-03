// 재귀 풀이
// memoization 풀이
// dp 풀이

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			int N = Integer.parseInt(br.readLine());

//			System.out.println(fibo1(N)); // 재귀

//			memo = new int[N + 1];
//			Arrays.fill(memo, -1);
//			memo[0] = 0;
//			memo[1] = 1;
//			System.out.println(fibo2(N)); // memoization

			System.out.println(fibo3(N)); // dp
		}
	} // main

	// 재귀
	static int fibo1(int n) {
		if (n <= 1) {
			return n;
		}
		return fibo1(n - 1) + fibo1(n - 2);
	}

	// memoization
	static int[] memo;

	static int fibo2(int n) {
		if (memo[n] == -1) {
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		}
		return memo[n];
	}

	// dp
	static int fibo3(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
