// BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 정점의 개수
		graph = new int[N][N];
		result = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			bfs(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int[] row : result) {
			for (int x: row) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	} // main
	
	static void bfs(int start) {
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int next = 0; next < N; next++) {
				if (graph[curr][next] == 1 && !visited[next]) {
					visited[next] = true;
					result[start][next] = 1;
					queue.offer(next);
				}
			}
		}
	}
	
	
}
