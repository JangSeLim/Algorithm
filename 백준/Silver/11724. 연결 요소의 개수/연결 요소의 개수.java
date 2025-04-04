// 그래프

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] graph;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수

		graph = new ArrayList[N + 1]; // 시작 정점 1
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		} // 그래프 입력 완료

		visited = new boolean[N + 1];
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	} // main

	static void dfs(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.add(start);
		visited[start] = true;
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			
			for (int i = graph[curr].size() - 1; i >= 0; i--) {
				int next = graph[curr].get(i);
				if (!visited[next]) {
					stack.push(next);
				}
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int next : graph[curr]) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}

}
