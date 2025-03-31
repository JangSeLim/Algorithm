// 집합의 개수 구하기
// 1을 발견하면 dfs로 돌기
// 방문처리로 0 넣기

import java.util.Scanner;

public class Main {

	static int M, N, K, cnt;
	static int[][] board;

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt(); // 배추밭의 가로길이
			N = sc.nextInt(); // 배추밭의 세로길이
			K = sc.nextInt(); // 배추가 심어져 있는 위치의 개수

			board = new int[M][N];
			for (int i = 0; i < K; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();

				board[X][Y] = 1;
			} // 입력 완료

			cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		} // 테스트케이스

	} // main

	private static void dfs(int i, int j) {
		board[i][j] = 0; // 방문처리

		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];

			// 범위를 벗어나면, 그리고 0이면
			if (nr < 0 || nr >= M || nc < 0 || nc >= N || board[nr][nc] == 0) continue;
			if (board[nr][nc] == 1) {
				board[nr][nc] = 0;
				dfs(nr, nc);
			}
			
		}

	}
}
