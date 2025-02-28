
// 위에서부터 내려오기
import java.util.Scanner;

public class Solution {

//	 좌, 우, 하
	static int[][] delta = { { 0, -1 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();

			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int answer = -1;

			for (int i = 0; i < 100; i++) {
				if (arr[0][i] != 1)
					continue;

				boolean[][] visit = new boolean[100][100];
				int r = 0;
				int c = i;

				while (!visit[r][c] && r < 99) {
					visit[r][c] = true;
					for (int d = 0; d < 3; d++) {
						int nr = r + delta[d][0];
						int nc = c + delta[d][1];
						if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && !visit[nr][nc] && arr[nr][nc] != 0) {
							r = nr;
							c = nc;
							break;
						}
					}
					if (arr[r][c] == 2) {
						answer = i;
						break;
					}
				}
			}

			System.out.println("#" + T + " " + answer);
		}
	}
}