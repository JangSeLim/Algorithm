// 위상정렬: 큐
// 인접행렬
// 사이클은 존재하지 않는다.
// 정점의 개수 V(3 ≤ V ≤ 1000), 정점은 1부터 시작
// 간선의 개수 E(2 ≤ E ≤ 3000)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			int V = sc.nextInt();
			int E = sc.nextInt();

			int[][] adj = new int[V + 1][V + 1];
			int[] degree = new int[V + 1]; // 진입차수 저장

			for (int i = 0; i < E; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();

				adj[s][e] = 1;
				degree[e]++;
			}

			Queue<Integer> queue = new LinkedList<>();

			// 진입차수가 0이면 큐에 넣기 (시작 점)
			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0) {
					queue.add(i);
				}
			}

			// 큐가 공백상태가 될 때까지 반복
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				sb.append(curr).append(" ");

				// 인접행렬로 연결된 간선 확인하기 + 간선을 -1하고 0이면 큐에 넣기
				for (int to = 1; to < V + 1; to++) {
					if (adj[curr][to] == 1) {
						degree[to]--;
						if (degree[to] == 0) {
							queue.add(to);
						}
					}
				}
			} // while

			System.out.println(sb.toString());

		} // tc

	} // main

}
