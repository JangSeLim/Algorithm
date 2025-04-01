// 플로이드워셜 알고리즘

import java.util.Scanner;

public class Solution {

	static final int INF = Integer.MAX_VALUE; // 오버플로우 방지
	static int N;
	static int[][] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			N = sc.nextInt(); // 사람 수
			dist = new int[N][N]; // 최단 거리 배열

			// 입력받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = sc.nextInt();
					if (i != j && dist[i][j] == 0) {
						dist[i][j] = INF;
					}
				}
			}

			// 플로이드-워셜 알고리즘 수행
			// 경 - 출 - 도
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (dist[i][k] == INF)
						continue;
					for (int j = 0; j < N; j++) {
						if (dist[k][j] == INF)
							continue;
						if (dist[i][k] != INF && dist[k][j] != INF) { // 오버플로우 방지
							dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
						}
					}
				}
			}

			// 최단 거리 합이 최소인 사람 찾기
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0; // 사람별 최단 거리 합 초기화
				for (int j = 0; j < N; j++) {
					sum += dist[i][j];
				}
				min = Math.min(min, sum);
			}

			sb.append(min);
			System.out.println(sb);
		}
		sc.close();
	}
}
