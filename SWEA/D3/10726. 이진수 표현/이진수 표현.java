
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if ((M & ((1 << N) - 1)) == (1 << N) - 1) {
				System.out.print("ON");
			} else {
				System.out.print("OFF");
			}
			System.out.println();
		}
		sc.close();
	}
}