import java.util.Scanner;

public class Solution {

	static int[] p;
	static int res;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			int N = sc.nextInt(); // 집합
			p = new int[N+1];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			int M = sc.nextInt(); // 연산의 개수
			for (int i = 0; i < M; i++) {
				int op = sc.nextInt();
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				int pa = findSet(A);
				int pb = findSet(B);
				
				if (op == 0) {
					union(pa, pb);
				} else if (op == 1) {
					if (findSet(pa) == findSet(pb)) sb.append(1);
					else sb.append(0);
				}
			}	
			System.out.println(sb.toString());
		} // tc
	} // main


	static int findSet(int x) {
		if (x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}

	static void union(int a, int b) {
		p[b] = a;
	}
	
	
}
