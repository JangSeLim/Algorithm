import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 상원이의 반 인원수
			int M = sc.nextInt(); // 친한 친구 관계의 수

			List<Integer>[] adj = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				adj[A].add(B);
				adj[B].add(A);
			}
			
			boolean[] invited = new boolean[N + 1];
			invited[1] = true;
			for (int i : adj[1]) {
				invited[i] = true;
				for (int j : adj[i]) {
					invited[j] = true;
				}
			}
			
			int cnt = 0;
			for (int i = 2; i <= N; i++) {
				if (invited[i]) cnt++;
			}
			
			System.out.println("#" + tc + " " + cnt);
		} // tc

	} // main
}