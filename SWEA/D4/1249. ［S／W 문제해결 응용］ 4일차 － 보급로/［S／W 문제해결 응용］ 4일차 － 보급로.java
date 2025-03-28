//dist[r][c] = r,c좌표까지 오는 데 걸린 가중치
//time[r][c] = r,c좌표 한 칸의 가중치

//1. 그래프의 크기만큼 2차원 배열 dist[][]를 만들고 INF를 넣기
//2. 시작 노드에서 가중치(문제에선 깊이(=시간))를 0으로 두고 다익스트라로 탐색을 시작(pq에 add)
//3.1 현재 노드에 인접한 노드 중, 갈 수 있는 노드(다음 노드)를 pq에 넣기
//3.2 이때 pq는 가중치에 대한 최소 힙(내부적으로 가중치 오름차순 자동 정렬)
//4.1 dist[][]에 다음 노드의 가중치의 누적 합 넣기
//4.2 이때 다음 노드의 가중치의 누적 합이 dist[nr][nc]에 들어있던 가중치보다 크다면 스킵
////최단 경로를 찾아야 하므로 이미 작은 값이 들어있다면 더 이상 탐색할 가치가 없다.
//5.1 인접한 노드를 모두 탐색하고 다시 pq에 있는 노드를 꺼내서 탐색을 시작
//5.2 이때 꺼낸 노드의 가중치와 dist[꺼낸 노드.r][꺼낸 노드.c]의 값을 비교하여 
//dist에 들어있는 값이 더 작다면 이 또한 스킵
////pq는 현재 가중치 기준 오름차순으로 정렬해놨기 때문에, pop하면 가중치가 가장 작은 노드가 튀어나온다.
//6. 위의 과정을 도착 지점에 도달할 때까지 반복한다.
//7. dist[도착지점.r][도착지점.c]이 답
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int r, c, cost;

		public Edge(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int N;
	static final int INF = Integer.MAX_VALUE;
	static int[][] time;
	static int[][] dist;
	
	// 우, 하, 좌, 상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt(); // 테스트 케이스 개수 입력

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			time = new int[N][N]; // r,c좌표 한 칸의 가중치
			dist = new int[N][N]; // r,c좌표까지 오는 데 걸린 가중치
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					time[i][j] = str.charAt(j) - '0';
					dist[i][j] = INF;
				}
			} // 입력 완료
			
			dist[0][0] = 0;
			
			dijkstra(0);	

			sb.append("#").append(tc).append(" ").append(dist[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0, start));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if (curr.cost > dist[curr.r][curr.c]) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				int next = curr.cost + (int) time[nr][nc];
				if (dist[nr][nc] > next) {
					dist[nr][nc] = next;
					pq.add(new Edge(nr, nc, next));
				}
						
			}
		}
		
	}
	
	 
}

