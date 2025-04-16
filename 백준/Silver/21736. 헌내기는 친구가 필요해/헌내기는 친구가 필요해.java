// bfs로 탐색

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt;
	static char[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];
		int row = -1;
		int col = -1;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j); // O는 빈공간, X는 벽, P는 사람
				if (map[i][j] == 'I') { // 도연이 위치 찾기
					row = i;
					col = j;
				}
			}
		}

		cnt = 0;
		bfs(row, col);
		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}

	static void bfs(int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		visited[row][col] = true;
        queue.add(new Point(row, col));

		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
					
					// 사람을 찾은 경우
					if (map[nr][nc] == 'P') {
						visited[nr][nc]= true;
						queue.add(new Point(nr, nc));
						cnt++;
					}
					// 빈공간을 찾은 경우
					else if (map[nr][nc] == 'O') {
						visited[nr][nc] = true;
						queue.add(new Point(nr, nc));
					}
				}
			}
		}

	}
}
