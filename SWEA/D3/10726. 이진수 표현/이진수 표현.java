
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			StringBuilder sb = new StringBuilder();

			if ((M & ((1 << N)-1)) == ((1 << N) - 1)) {
				sb.append("ON");
			} else {
				sb.append("OFF");
			}
			
			System.out.println("#" + tc + " " + sb.toString());
		} // tc

	}
}
