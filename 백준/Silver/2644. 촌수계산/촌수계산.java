import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] depth;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람들의 수
		int A = sc.nextInt();
		int B = sc.nextInt();
		int M = sc.nextInt();

		depth = new int[N + 1];
		Arrays.fill(depth, -1);
		
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
		
		bfs(A);
		System.out.println(depth[B]);

	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		depth[start] = 0;
		
		while (!queue.isEmpty()) {
			int curr =  queue.poll();
			for (int next : adj[curr]) {
				if (depth[next] == -1) {
					depth[next] = depth[curr] + 1;
					queue.add(next);
				}
			}
			
		}
		
	} // bfs
}
