// n을 최소 개수의 제곱수의 합으로 표현할 때 그 개수를 구하기
// 범위: 1 <= n <= 50000
// dp

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int dp[] = new int[N+1];  // dp[i]: i를 제곱수 합으로 나타낼 때 최소 개수
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i =2; i <= N; i++) {
			for (int j = 1; j*j <= i; j++) { // j*j가 i 이하인 모든 제곱수 탐색
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		System.out.println(dp[N]);
		
	} // main

	
}
