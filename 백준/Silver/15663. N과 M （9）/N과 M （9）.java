import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr, nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);

		arr = new int[M];
		visited = new boolean[N + 1];
		recur(0);
		System.out.println(sb);

	}

	static void recur(int idx) {
		if (idx == M) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}

		int before = 0; // 중복되는 수열을 배제시키기 위해
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			if (before != nums[i]) {
				visited[i] = true;
				arr[idx] = nums[i];
				before = nums[i];
				recur(idx+1);
				visited[i] = false;
			}
		}

	}

}
// 중복 순열
