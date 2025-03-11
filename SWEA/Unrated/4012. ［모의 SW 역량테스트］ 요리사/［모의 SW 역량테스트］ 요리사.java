import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 방문 여부를 저장할 배열
	static boolean[] visited;
	// 사람 수(N)와 결과 값의 최소 차이(minDiff)
	static int N, minDiff;
	// 점수 배열
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			minDiff = Integer.MAX_VALUE;
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력받기 끝

			// 조합을 구하는 함수 호출 (처음에는 0번째 사람부터 시작, 선택된 인원 수는 0)
			comb(0, 0);

			System.out.println("#" + tc + " " + minDiff);
		} // tc 반복문 종료
	}

	// idx: 현재 인덱스, cnt: 현재까지 선택한 사람 수
	public static void comb(int idx, int cnt) {
		// 만약에 N/2 명을 선택했으면, 두 팀을 나누고 계산을 시작
		if (cnt == N / 2) {
			int sumA = 0; // 첫 번째 팀의 점수 합
			int sumB = 0; // 두 번째 팀의 점수 합

			// 모든 사람들을 돌면서, 각 팀에 속하는 사람들끼리 점수를 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 팀 A에 속한 사람들끼리의 점수 합
					if (visited[i] && visited[j]) {
						sumA += arr[i][j];
					}
					// 팀 B에 속한 사람들끼리의 점수 합
					if (!visited[i] && !visited[j]) {
						sumB += arr[i][j];
					}
				}
			}

			// 현재 계산된 두 팀의 점수 차이를 구하고, 최소 차이를 갱신
			minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
			return;
		}

		// 재귀적으로 조합을 뽑아낸다.
		for (int i = idx; i < N; i++) {
			// 만약 현재 사람이 방문되지 않았다면, 해당 사람을 팀 A로 선택
			if (!visited[i]) {
				visited[i] = true; // 해당 사람을 방문 처리
				// 다음 사람을 선택하기 위해 재귀적으로 comb 함수 호출
				comb(i + 1, cnt + 1);
				visited[i] = false; // 백트래킹: 선택을 되돌려 방문 처리를 해제
			}
		}
	}
}
