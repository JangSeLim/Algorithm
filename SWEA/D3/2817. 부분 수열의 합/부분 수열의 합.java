import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, K, cnt;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			cnt = 0;
			findSubset(0, 0);

			System.out.println("#" + tc + " " + cnt);
		} // tc
	} // main

	static void findSubset(int idx, int sum) {
		if (idx == N) {
			return;
		}

		// 현재 요소를 선택하는 경우
		if (sum + arr[idx] == K) {
			cnt++;
		}

		findSubset(idx + 1, sum + arr[idx]);
		findSubset(idx + 1, sum);

	}

}
