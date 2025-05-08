import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 친구 관계 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			graph[B].add(A);
		}
		
		int minValue = Integer.MAX_VALUE;
		int answer = 0;
		
		//각 사람마다 BFS 실행
		for (int i = 1; i <= N; i++) {
			int total = bfs(i);
			if (total < minValue) {
				minValue = total;
				answer = i;
			}
		}
		
		System.out.println(answer);
		
	} // main
	
	static int bfs(int start) {
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for (int next : graph[curr]) {
				if (!visited[next]) {
					visited[next] = true;
					dist[next] = dist[curr] + 1;
					queue.offer(next);
				}
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += dist[i];
		}
		return sum;
	}
}
