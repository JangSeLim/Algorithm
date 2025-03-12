import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int[][] board;
    static int N;
    static List<Integer> A;
    static List<Integer> B;
    static int minDiff;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            board = new int[N][N];
            // 시너지 입력받기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    board[r][c] = sc.nextInt();
                }
            }

            A = new ArrayList<>();
            B = new ArrayList<>();

            minDiff = Integer.MAX_VALUE; // 초기값을 매우 큰 값으로 설정
            A.add(0); // 첫 번째 재료는 A에 넣기
            recur(1);

            System.out.println("#" + tc + " " + minDiff);
        }
    }

    // 재귀 단계마다, 현재 식재료가 A음식에 들어갈 지 B에 들어갈 지 결정
    static void recur(int level) {
        if (level == N) {
            // A와 B의 시너지 합 계산
            int Asum = 0;
            for (int i = 0; i < A.size(); i++) {
                for (int j = i + 1; j < A.size(); j++) {
                    int a = A.get(i);
                    int b = A.get(j);
                    Asum += board[a][b] + board[b][a];
                }
            }

            int Bsum = 0;
            for (int i = 0; i < B.size(); i++) {
                for (int j = i + 1; j < B.size(); j++) {
                    int a = B.get(i);
                    int b = B.get(j);
                    Bsum += board[a][b] + board[b][a];
                }
            }

            // 시너지 차이 계산 후, 최소값 갱신
            minDiff = Math.min(minDiff, Math.abs(Asum - Bsum)); // 차이를 계산하여 최소값 갱신

            return;
        }

        // level번째 식재료를 A음식에 추가
        if (A.size() < N / 2) {
            A.add(level);
            recur(level + 1);
            A.remove(A.size() - 1);
        }

        // level번째 식재료를 B음식에 추가
        if (B.size() < N / 2) {
            B.add(level);
            recur(level + 1);
            B.remove(B.size() - 1);
        }
    }
}
