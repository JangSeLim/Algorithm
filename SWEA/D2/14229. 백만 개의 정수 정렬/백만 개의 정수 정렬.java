// 호어 파티션 : 500000 인덱스 바로 출력
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static int N = 1000000; // 백만개의 정수
	static int[] arr = new int[N];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = quickSort(0, N - 1, 500000);

		System.out.println(result);
	}

	static int quickSort(int start, int end, int k) {
		if (start < end) {
			int pivot = hoarePart(start, end);

			if (pivot == k) {
				return arr[pivot];
			}

			if (pivot > k) {
				return quickSort(start, pivot - 1, k);
			} else {
				return quickSort(pivot + 1, end, k);
			}
		}
		return -1;
	}

	static int hoarePart(int start, int end) {
		int pivot = arr[start];
		int L = start + 1;
		int R = end;

		while (L <= R) {
			// L: 피벗보다 큰 값
			while (L <= R && arr[L] <= pivot)
				L++;

			// R: 피벗보다 작거나 같은 값
			while (arr[R] > pivot)
				R--;

			// 스왑
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}

		// R과 피벗 위치 교환
		int tmp = arr[start];
		arr[start] = arr[R];
		arr[R] = tmp;

		return R;
	}

}