
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int N, M, R;
	static List<Integer>[] adj;
	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		} // 초기화

		for (int i = 0; i < M; i++) {
			int U = sc.nextInt();
			int V = sc.nextInt();

			adj[U].add(V);
			adj[V].add(U);
		} // 입력 받기

		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		} // 오름차순 정렬

		dfs(R);
		sb.append("\n");
		bfs(R);

		System.out.println(sb.toString());
	} // main

	static void dfs(int start) {
		visited = new boolean[N + 1];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);

		while (!stack.isEmpty()) {
			int curr = stack.pop();

			if (!visited[curr]) {
				visited[curr] = true;
				sb.append(curr).append(" ");

				for (int i = adj[curr].size() - 1; i >= 0; i--) {
					int next = adj[curr].get(i);
					if (!visited[next]) {
						stack.push(next);
					}
				}

			}
		}

	} // dfs

	static void bfs(int start) {
		visited = new boolean[N + 1];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");

			for (int w : adj[curr]) {
				if (!visited[w]) {
					queue.add(w);
					visited[w] = true;
				}
			}
		}

	} // bfs
}
