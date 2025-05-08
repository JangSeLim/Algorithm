
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 정점의 개수
		graph = new int[N][N];
		result = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 플로이드 워셜
		for (int k = 0; k < N; k++) { // 거쳐가는 정점
			for (int i = 0; i < N; i++) { // 출발 정점
				for (int j = 0 ; j < N; j++) { // 도착 정점
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}
		
		// 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int[] row : graph) {
            for (int x : row) sb.append(x).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
		
	} // main
	
}
