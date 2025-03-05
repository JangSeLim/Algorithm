
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	
	static boolean[] visited;
	static int N, minDiff;
	static int[][] arr;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			arr = new int[N][N];
			minDiff = Integer.MAX_VALUE;
			visited = new boolean[N];
			for (int i = 0; i <N; i++) {
				for (int j = 0; j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			comb(0, 0);
			
			System.out.println("#" + test_case + " " + minDiff);
		}
	}
	
	public static void comb(int idx, int cnt) {
		if (cnt == N/ 2) {
			// 그룹 나누기
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i] && visited[j]) {
						sumA += arr[i][j];
					}
					if (!visited[i] && !visited[j]) {
						sumB += arr[i][j];
					}
				}
			}
			
			// minDiff 갱신
			minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
			
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
}

// 식재료를 N/2개씩 나누어서 두 개의 요리
// A음식과 B음식의 맛 차이를 최소가 되도록 배분
// 두음식간의 맛의 차이가 최소가 되는 경우

// N/2개 선택하는 조합 문제
// 1. N길이의 방문 배열 생성
// 2. N개 중에 N/2개 선택하는 조합 -> 나머지는 자동으로 B그룹
// 3. 각 그룹의 시너지 저장
// 4. 두 그룹의 맛 차이 계산, 최솟값 갱신
