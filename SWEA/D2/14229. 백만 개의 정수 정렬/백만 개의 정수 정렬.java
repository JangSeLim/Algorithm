// 로무토 파티션
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

		quickSort(0, N - 1);
        
		System.out.println(arr[500000]);
	}

	static void quickSort(int start, int end) {
		if (start < end) {
			int pivot = lomutoPart(start, end);
			quickSort(start, pivot - 1);
			quickSort(pivot + 1, end);
		}
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