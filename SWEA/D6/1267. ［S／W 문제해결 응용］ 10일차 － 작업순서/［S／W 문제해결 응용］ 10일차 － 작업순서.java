// 위상정렬: 스택 -> dfs로 구현
// 인접리스트
// 사이클은 존재하지 않는다.
// 정점의 개수 V(3 ≤ V ≤ 1000), 정점은 1부터 시작
// 간선의 개수 E(2 ≤ E ≤ 3000)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	static int V, E;
	static List<Integer>[] adj;
	static boolean[] visited;
	static Stack<Integer> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			V = sc.nextInt();
			E = sc.nextInt();

			adj = new ArrayList[V + 1];
			for (int i = 1; i < V + 1; i++) {
				adj[i] = new ArrayList<>();
			}

			int[] degree = new int[V + 1]; // 진입차수 저장
			visited = new boolean[V + 1];
			ans = new Stack<>();

			for (int i = 0; i < E; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();

				adj[s].add(e);
				degree[e]++;
			}

			// 진입차수가 0이면 큐에 넣기 (시작 점)
			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0) {
					dfs(i);
				}
			}

			// 출력
			while (!ans.isEmpty()) {
				sb.append(ans.pop()).append(" ");
			}
			System.out.println(sb.toString());

		} // tc

	} // main

	// v: 현재 방문 시작점
	static void dfs(int v) {
		visited[v] = true;
		
		for (int to : adj[v]) {
			if (!visited[to]) {
				dfs(to);
			}
		}
		ans.push(v);
	} //dfs

}
