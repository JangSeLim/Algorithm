import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, min;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N]; // 방문 여부
		min = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(min);

	}

	// index: 인덱스, cnt: 조합의 길이
	static void comb(int idx, int cnt) {
		// 종료 조건: 팀 완성
		if (cnt == N/2) {
			power(); // 팀 나눠서 능력치 계산하기
			return;
		}

		// 재귀 조건
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}

	static void power() {
		int tStart = 0;
		int tLink = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// true -> tStart
				if (visited[i] && visited[j]) {
					tStart += map[i][j];
					tStart += map[j][i];
				}
				// false -> tLink
				else if (!visited[i] && !visited[j]) {
					tLink += map[i][j];
					tLink += map[j][i];
				}
			}
		}
		
		int diff = Math.abs(tStart - tLink);
		if (diff == 0) {
			min = 0;
			return;
		}
		min = Math.min(diff, min);

	}

}
