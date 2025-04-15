// 이진탐색으로 구현
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 상근이가 집으로 가져가려고 하는 나무의 길이

		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());
		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			maxHeight = Math.max(maxHeight, tree[i]); // 나무의 최대 크기 구하기
		} // 나무 입력 완료

		// 이진탐색 시작
		int low = 0; // 절단기의 최소 높이
		int high = maxHeight; // 절단기의 최대 높이
		int res = 0; // 최종 결과(가장 높이 자를 수 있는 절단기 높이)
		while (low <= high) {
			int mid = (low + high) / 2;
			long sum = 0; // 잘라서 얻은 나무의 총합
			
			for (int i = 0; i < N; i++) {
				if (tree[i] > mid) {
					sum += (tree[i] - mid);
				}
			}
			
			if (sum >= M) {
				// 충분히 얻었으면, 더 높이 잘라도 되니까 low를 올림
				res = mid;
				low = mid + 1;
			} else {
				// 부족하면, 절단기 높이를 낮춰야 함
				high = mid - 1;
			}
		}

		System.out.println(res);
	} // main
}
