
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = (M % 2);
				M /= 2;
			}
//			System.out.println(Arrays.toString(arr));
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] == 1) {
					sum += 1;
				}
			}
			
			if (sum == N) {
				System.out.print("ON");
			} else {
				System.out.print("OFF");
			}
			System.out.println();
		}
	}
}