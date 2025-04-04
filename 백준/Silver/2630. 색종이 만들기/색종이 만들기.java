// 재귀
// 분할 정복

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int white, blue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		white = 0;
		blue = 0;
		divide(0, 0, N);

		System.out.println(white);
		System.out.println(blue);
	} // main

	// 4등분으로 나눠서 각각 재귀 호출
	static void divide(int r, int c, int size) {
		// 같은 색깔이라면 해당 부분은 종료
		if (sameColor(r, c, size)) {
			if (arr[r][c] == 0) {
				white++;
			} else {
				blue++;
			}

			return;
		}

		// 아니면 4분할
		size /= 2;
		divide(r, c, size); // 왼쪽 위
		divide(r + size, c, size); // 왼쪽 아래
		divide(r, c + size, size); // 오른쪽 위
		divide(r + size, c + size, size); // 오른쪽 아래
	} // divide

	// 해당 부분이 같은 색깔인지 확인
	static boolean sameColor(int r, int c, int size) {
		int color = arr[r][c];
		for (int i = r; i < size + r; i++) {
			for (int j = c; j < size + c; j++) {
				// 종료 조건
				if (arr[i][j] != color)
					return false;
			}
		}

		return true;
	} // sameColor

}
