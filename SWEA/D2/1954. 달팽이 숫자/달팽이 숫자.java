//import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            int d = 1;
            int K = N;
            int row = 0;
            int col = -1;
            int num = 1;

            while (K > 0) {
                // 수평 이동
                int i = 0;
                while (i < K) {
                    col += d;
                    arr[row][col] = num++;
                    i++;
                }
                K--;

                if (K == 0) break; // K가 0이면 종료

                // 수직 이동
                i = 0;
                while (i < K) {
                    row += d;
                    arr[row][col] = num++;
                    i++;
                }

                // 방향 전환
                d *= -1;
            }

            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
