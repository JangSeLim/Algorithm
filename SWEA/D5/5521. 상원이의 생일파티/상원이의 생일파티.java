
//import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 인원 수
			int M = sc.nextInt(); // 관계 수

			List<Integer>[] adjList = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				adjList[A].add(B);
				adjList[B].add(A);
			}

//            // 각 사람의 친구 리스트 출력
//            System.out.println("친구 관계 ");
//            for (int i = 1; i <= N; i++) {
//                System.out.print(i + "번: ");
//                for (int friend : adjList[i]) {
//                    System.out.print(friend + " ");
//                }
//                System.out.println();
//            }

			boolean[] invited = new boolean[N + 1];
			invited[1] = true;
			for (int i : adjList[1]) {
				invited[i] = true; // 친구 초대

				for (int j : adjList[i]) {
					invited[j] = true; // 친구의 친구 초대
				}
			}

			int cnt = 0;
			for (int i = 2; i <= N; i++) {
				if (invited[i])
					cnt++;
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}
}
