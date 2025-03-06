
import java.util.Scanner;

class Solution {
	
	static int[] memo;
	
	public static void main(String args[]) throws Exception {


		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			memo = new int[M+1];
			
			System.out.println("#" + T + " " + recur(N, M));
		}
		sc.close();
	}
	
	static int recur(int N, int M) {
		if (M == 0) return 1;
		
		if (memo[M] != 0) return memo[M];
		
		return memo[M] = N * recur(N, M-1);
	}
}