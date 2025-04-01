// 단지 개수: DFS
// 각 단지별로 집의 개수도 출력 (오름차순 출력)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static int vCnt; // 단지의 개수
	static int hCnt; // 집의 개수
	static ArrayList<Integer> houseCnt = new ArrayList<>();

	// 상하좌우 집 확인
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		sc.nextLine();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		} // 배열로 입력 완료

		vCnt = 0; // 단지 수 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					hCnt = 1; // 집의 개수 초기화
					vCnt++; // 단지 수 증가
					dfs(i, j);
					houseCnt.add(hCnt); // 저장
				}
			}
		}
		
		Collections.sort(houseCnt); // 오름차순 정렬

		System.out.println(vCnt);
		for (int cnt : houseCnt) {
			System.out.println(cnt);
		}
	} // main

	static void dfs(int r, int c) {
		map[r][c] = 0; // 방문 처리

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1) {
				map[r][c] = 0; // 방문 처리
				hCnt++;
				dfs(nr, nc);
			}
		}

	}

}
