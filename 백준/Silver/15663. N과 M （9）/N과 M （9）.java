import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		nums = new int[M];
		visited = new boolean[N + 1];
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
		
		int before = 0; // 중복되는 수열 배제
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			if (before != arr[i]) {
				visited[i] = true;
				nums[idx] = arr[i];
				before = arr[i];
				recur(idx + 1);
				visited[i] = false;
			}
		}

	}

}
