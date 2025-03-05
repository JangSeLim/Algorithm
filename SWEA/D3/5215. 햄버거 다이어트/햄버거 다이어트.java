
import java.util.Scanner;

class Solution {
	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int[][] arr; // 0: 점수, 1: 칼로리(재료)
	static boolean[] sel; // 재료 선택할지 안할지
	static int max;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][2];
			sel = new boolean[N];
			max = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			powerset(0);
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}

	public static void powerset(int idx) {
		// 종료 시
		if (idx == N) {
			int cSum = 0;
			int totalScore = 0;
			
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					cSum += arr[i][1]; // 칼로리 더하기
					totalScore += arr[i][0]; // 점수 더하기
				}
			}
			
			// 만약 칼로리 합산이 제한 칼로리 이하라면
			if (cSum <= L) {
				max = Math.max(max, totalScore);
			}
			return;
		}

		sel[idx] = false;
		powerset(idx + 1);
		sel[idx] = true;
		powerset(idx + 1);

	}
}
// 햄버거 먹으면서 다이어트 성공하기
// 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합해주는 프로그램
// 햄버거 선호도: 재료들의 맛에 대한 점수의 합산
// 같은 재료 여러번 사용 불가능

// 0. 부분집합 구하기
// 1. 부분집합별로 칼로리의 합 구하기
// 2. 칼로리의 합이 L이내라면
// 3. 최대 점수 갱신
// 부분집합 탐색(비트마스크 또는 재귀)