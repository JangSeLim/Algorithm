import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static boolean[] visited;
	static List<Integer>[] adj;
	static int[] order;
	static int cnt = 1;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 정점의 수
		int M = sc.nextInt(); // 간선의 수
		int R = sc.nextInt(); // 시작 정점		
		
		visited = new boolean[N+1];
		order = new int[N + 1];
		adj = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		} // 초기화
		
		for (int i = 0 ; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A].add(B);
			adj[B].add(A);
		} // 간선 입력받기
		
		// 오름차순 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		
		dfs(R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		order[start] = cnt++; // 방문순서저장
		
		for (int next : adj[start]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
		
	}
}
