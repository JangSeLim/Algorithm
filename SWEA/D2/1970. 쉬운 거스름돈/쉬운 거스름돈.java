// dp로 풀었는데 시간초과... 그리디 알고리즘 사용하는 게 훨씬 빠르다. O(N) -> O(1)
// 10 <= N <= 1000000
// N의 마지막 자릿수는 항상 0
// 50000, 10000, 5000, 1000, 500, 100, 50, 10

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] cheese = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();

			int N = Integer.parseInt(br.readLine()); // 돈
			int[] res = new int[cheese.length]; // 사용한 동전 기록

			for (int i = 0; i < cheese.length; i++) {
				if (N >= cheese[i]) {
					res[i] = N / cheese[i];
					N %= cheese[i];
				}
			}

			sb.append("#").append(tc).append("\n");
			for (int r : res) {
				sb.append(r).append(" ");
			}
			System.out.println(sb);
		} // tc

	} // main
}
