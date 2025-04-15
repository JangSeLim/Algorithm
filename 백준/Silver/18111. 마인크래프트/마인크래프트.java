import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 인벤토리 블록 개수

		int[] count = new int[257]; // 높이별 블록 개수 저장 (0 ~ 256)
		int totalBlocks = B; // 전체 블록 수 = 인벤토리 + 땅에 깔린 블록 수
		int min = 256;
		int max = 0;

		// 입력 받으면서 count 배열에 각 높이 개수 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int h = Integer.parseInt(st.nextToken());
				count[h]++;
				totalBlocks += h;
				min = Math.min(min, h); // 최소 높이
				max = Math.max(max, h); // 최대 높이
			}
		}

		int bestTime = Integer.MAX_VALUE; // 최소 시간
		int bestHeight = 0;               // 그 때의 높이

		// 가능한 목표 높이 h를 모두 시도 (min ~ max)
		for (int target = min; target <= max; target++) {
			int remove = 0; // 제거해야 할 블록 수
			int add = 0;    // 추가해야 할 블록 수

			// 각 높이 h에서 target으로 맞추기 위해 필요한 작업 계산
			for (int h = 0; h <= 256; h++) {
				int diff = h - target;
				if (diff > 0) {
					// 현재 높이가 목표보다 높으면 블록 제거
					remove += diff * count[h];
				} else if (diff < 0) {
					// 현재 높이가 목표보다 낮으면 블록 추가
					add -= diff * count[h];
				}
			}

			// 제거한 블록 + 인벤토리로 추가할 블록을 충당할 수 있는 경우만 처리
			if (remove + B >= add) {
				int time = remove * 2 + add; // 제거: 2초, 추가: 1초

				// 더 빠른 시간 or 시간이 같을 경우 더 높은 높이를 선택
				if (time < bestTime || (time == bestTime && target > bestHeight)) {
					bestTime = time;
					bestHeight = target;
				}
			}
		}

		// 결과 출력: 최소 시간과 그때의 높이
		System.out.println(bestTime + " " + bestHeight);
	}
}
