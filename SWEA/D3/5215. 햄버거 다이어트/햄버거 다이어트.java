import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, L, max;
	static int[] score, cal;
	static boolean[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			score = new int[N]; // 점수
			cal = new int[N]; // 칼로리
			for (int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			selected = new boolean[N];
			dfs(0);

			System.out.println("#" + tc + " " + max);
		} // tc
	} // main

	static void dfs(int idx) {
		if (idx == N) {
			int totalCal = 0;
			int totalScore = 0;
			
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					totalCal += cal[i];
					totalScore += score[i];
				}
			}
			
			if (totalCal <= L) {
				max = Math.max(max, totalScore);
			}
			return;
		}
		
		selected[idx] = true;
		dfs(idx + 1);
		
		selected[idx] = false;
		dfs(idx + 1);
	}

}