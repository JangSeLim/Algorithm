import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static boolean[] visited;
	static int[] order;
	static List<Integer>[] adj;
	static int cnt;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt(); // 정점의 수
		int M = sc.nextInt(); // 간선의 수
		int R = sc.nextInt(); // 시작 정점

		visited = new boolean[N + 1];
		order = new int[N + 1];
		cnt = 1;
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int U = sc.nextInt();
			int V = sc.nextInt();
			
			adj[U].add(V);
			adj[V].add(U);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i], Collections.reverseOrder());
		}
		
		dfs(R);
		for (int i = 1; i <= N; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb.toString());

	}
	
	static void dfs(int start) {
		visited[start] = true;
		order[start] = cnt++;
		
		for (int next: adj[start]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

}
