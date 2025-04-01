// DFS 완탐 -> 시간초과 날 수 있음
// BFS로 풀자!

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 언니
		K = sc.nextInt(); // 동생

		System.out.println(bfs(N));
	} // main

	// 3가지 경우 탐색 지점
	static int bfs(int start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start, 0}); // 이동 횟수 저장
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int pos = curr[0];
			int time = curr[1];
			
			if (pos == K) return time;
			
			int[] nextMove = {pos -1, pos+1, pos*2};
			for (int next: nextMove) {
				if (next >= 0 & next <= 100000 && !visited[next]) {
					visited[next] = true; // 중복 방지
					queue.add(new int[] {next, time+1});
				}
			}
			
			
		}
		return -1;
	} // bfs

}
