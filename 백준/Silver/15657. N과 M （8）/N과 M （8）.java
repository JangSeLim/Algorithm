import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] nums;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		
		sel = new int[M];
		recur(0, 0);
		System.out.println(sb.toString());
	}
	
	static void recur(int idx, int start) {
		if (idx == M) {
			for (int n : sel) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			sel[idx] = nums[i];
			recur(idx+1, i);
		}
		
	}
	
}
