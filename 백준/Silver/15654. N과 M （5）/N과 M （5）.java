import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		nums = new int[M];
		visited = new boolean[N];
		recur(0);
		System.out.println(sb);
	}

	static void recur(int idx) {
		if (idx == M) {
			for (int n : nums) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				nums[idx] = arr[i];
				recur(idx + 1);
				visited[i] = false;
			}
		}
	}
}