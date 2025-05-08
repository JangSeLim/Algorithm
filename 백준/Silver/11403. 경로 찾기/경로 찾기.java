// DFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			boolean[] visited = new boolean[N];
			dfs(i, visited);
			for (int j = 0; j < N; j++) {
				if (visited[j]) result[i][j] = 1;
			}
		}
		
		for (int[] row : result) {
			for (int x : row) System.out.print(x + " ");
			System.out.println();
		}
		
	} // main
	
	static void dfs(int start, boolean[] visited) {
		for (int i = 0; i < N; i++) {
			if (graph[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i, visited);
			}
		}
	}
}
