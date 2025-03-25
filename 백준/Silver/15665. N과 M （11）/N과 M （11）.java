import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] nums, res;
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
		
		res = new int[M];
		recur(0);
		System.out.println(sb);
		
	}
	static void recur(int idx) {
		if (idx == M) {
			for (int i = 0; i <M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int before = -1;
		for (int i = 0; i < N; i++) {
			int now = nums[i];
			if (before != now) {
				before = now;
				res[idx] = nums[i];
				recur(idx+1);
			}
		}
	}
}
