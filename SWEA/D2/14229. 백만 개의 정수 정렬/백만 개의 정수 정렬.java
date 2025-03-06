// 로무토 파티션, 500000까지만 돌리기
import java.util.Scanner;

class Solution {

	static int N = 1000000; // 백만개의 정수
	static int[] arr = new int[N];

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int result = quickSort(0, N - 1, 500000);

		System.out.println(result);
	}

	static int quickSort(int start, int end, int k) {
		if (start <= end) {
			int pivot = lomutoPart(start, end);

			// k번째 값이 pivot에 해당하면 그 값을 반환
			if (pivot == k) {
				return arr[pivot];
			}

			// k번째 값이 pivot보다 왼쪽에 있으면 왼쪽 부분을 재귀 호출
			else if (pivot > k) {
				return quickSort(start, pivot - 1, k);
			}

			// k번째 값이 pivot보다 오른쪽에 있으면 오른쪽 부분을 재귀 호출
			else {
				return quickSort(pivot + 1, end, k);
			}
		}
		return -1;
	}

	static int lomutoPart(int start, int end) {
		int pivot = arr[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		} // 경계

		int tmp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = tmp;

		return i + 1;
	}

}