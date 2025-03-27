import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] p;
	static int res;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 집합
			p = new int[N + 1];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			int M = sc.nextInt(); // 연산의 개수
			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				int pa = findSet(A);
				int pb = findSet(B);

				union(pa, pb);
			}
			res = 0;
			for (int i = 0; i < N; i++) {
				if (i == p[i]) {
					res++;
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		} // tc
		System.out.println(sb.toString());
	} // main

	static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}

	static void union(int a, int b) {
		p[b] = a;
	}

}
