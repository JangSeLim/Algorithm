// bfs 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	static boolean[][] visited;
	static int N, M, L, ans; // 탈주범이 위치할 수 있는 장소의 개수

	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] dir = { {}, // 0번은 없음 (빈 칸)
			{ 0, 1, 2, 3 }, // 1: 상하좌우
			{ 0, 1 }, // 2: 상하
			{ 2, 3 }, // 3: 좌우
			{ 0, 3 }, // 4: 상우
			{ 1, 3 }, // 5: 하우
			{ 1, 2 }, // 6: 하좌
			{ 0, 2 } // 7: 상좌
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로크기
			M = Integer.parseInt(st.nextToken()); // 가로크기
			int R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 위치의 세로
			int C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 위치의 가로
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간

			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 완료
			
			bfs(R, C);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		} // tc
		System.out.println(sb);

	} // main

	static void bfs(int startR, int startC) {
		Queue<Point> queue = new LinkedList<>();
		visited[startR][startC] = true;
		queue.add(new Point(startR, startC, 1));
		ans = 1;
		
		while (!queue.isEmpty()) {
			Point curr = queue.poll();

			// 위치 이동을 멈추기 위한 조건
			if (curr.time == L) {
				continue;
			}
			
			int currPos = map[curr.r][curr.c];
			for (int d : dir[currPos]) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				// 범위 체크
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
				
				int nextPos = map[nr][nc];
				if (nextPos == 0) continue;
				
				// 반대 방향도 연결되어 있는지 확인
				boolean canGo = false;
				for (int nd : dir[nextPos]) {
					if (nr + dr[nd] == curr.r && nc + dc[nd] == curr.c) {
						canGo = true;
						break;
					}
				}
				
				// 갈 수 있다면
				if (canGo) {
					visited[nr][nc] = true;
					ans++;
					queue.add(new Point(nr, nc, curr.time+1));
				}
				
			}
			
		} // while

	}

}