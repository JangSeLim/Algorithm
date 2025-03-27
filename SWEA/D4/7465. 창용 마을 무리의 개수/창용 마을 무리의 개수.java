import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static int N, M;
	static int[] input;
	static boolean[] visited;
	static ArrayList<Integer>[] edge;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 집합
			input = new int[N + 1];
			visited = new boolean[N + 1];
			edge = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				edge[i] = new ArrayList<Integer>();
			}

			int M = sc.nextInt(); // 연산의 개수
			for (int i = 0; i < M; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				edge[st].add(ed);
				edge[ed].add(st);

			}
			int res = 0;
			for (int i = 1; i <= N; i++) {
				if (visited[i]) continue;
				dfs(i);
				res++;
			}
			
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		} // tc
		System.out.println(sb.toString());
	} // main

	static void dfs(int curr) {
		visited[curr] = true;
		
		for (int eg : edge[curr]) {
			if (visited[eg]) continue;
			dfs(eg);
		}
		
	}

	

}
