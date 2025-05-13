import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] map, dist;
	static boolean[][] visited;
	
	// 상하좌우 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dist = new int[n][m];
		visited = new boolean[n][m];
		int r = -1, c = -1;
		for (int i = 0 ; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					r = i;
					c = j;
				}
			}
		} // 입력 완료
		
		bfs(r, c);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					sb.append(0).append(" ");
				} else if (!visited[i][j]) {
					sb.append(-1).append(" " );
				} else {
					sb.append(dist[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		
	} // main

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		dist[r][c] = 0;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				dist[nr][nc] = dist[cr][cc] + 1;
				queue.offer(new int[]{nr, nc});
			}
		}
		
	}

}
