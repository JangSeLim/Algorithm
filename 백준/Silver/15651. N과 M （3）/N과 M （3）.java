import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		
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
		
		for (int i = 1 ; i <= N; i++) {
				nums[idx] = i;
				recur(idx+1);
		}
	}
}