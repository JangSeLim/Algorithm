// 최단 경로 문제: BFS 사용 (Queue)
// 나이트의 현재 위치와 목표 위치 입력받기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int I, r2, c2, cnt;
	static boolean[][] visited;

	// 나이트의 이동 가능한 위치
	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			I = sc.nextInt(); // 체스판 한 변의 길이
			// 현재 위치
			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			// 목표 위치
			r2 = sc.nextInt();
			c2 = sc.nextInt();

			visited = new boolean[I][I];
			System.out.println(bfs(r1, c1));

		} // tc
	} // main

	static int bfs(int r1, int c1) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r1, c1, 0 }); // 이동횟수
		visited[r1][c1] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			int move = curr[2];

			if (r == r2 && c == c2) {
				return move;
			}

			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < I && nc >= 0 && nc < I && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc, move + 1 });
				}
			}

		}
		return -1;
	}
}
