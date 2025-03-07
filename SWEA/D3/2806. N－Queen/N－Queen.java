import java.util.Scanner;

class Solution {
	static int[] arr;
	static int N;
	static int cnt;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			cnt = 0;
			
			nQueen(0);
			System.out.println("#" + tc + " " + cnt);
		}

	} // main

	static void nQueen(int idx) {
		if (idx == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[idx] = i;
			if (possibility(idx)) {
				nQueen(idx + 1);
			}
		}
	}
	
	static boolean possibility(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			}
			
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		
		return true;
	}

}
