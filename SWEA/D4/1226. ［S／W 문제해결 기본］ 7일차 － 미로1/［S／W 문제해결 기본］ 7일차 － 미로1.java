
// 미로1
// bfs
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] map;
	static boolean[][] visited;
	static int ans;

	static class Point {
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();
			map = new int[16][16];
			visited = new boolean[16][16];
			int row = 0;
			int col = 0;
			for (int i = 0; i < 16; i++) {
				String str = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0'; // 숫자 변환
					// 2이면 시작점
					if (map[i][j] == 2) {
						row = i;
						col = j;
					}
					if (map[i][j] == 1) {
						visited[i][j] = true; // 벽은 방문한 것으로 체크
					}
				}
			} // 입력 완료

			// dfs
			ans = bfs(row, col);

			System.out.println("#" + T + " " + ans);
		} // tc

	} // main

	static int bfs(int startR, int startC) {
		Queue<Point> queue = new LinkedList<>();
		visited[startR][startC] = true;
		queue.offer(new Point(startR, startC));
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			if (map[curr.r][curr.c] == 3) {
				return 1;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && !visited[nr][nc] && map[nr][nc] != 1) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		return 0;
	}

}