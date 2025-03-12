import java.util.Scanner;

class Solution {
    static int N;
    static int[][] board;
    static int cnt;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            board = new int[N][N];
            cnt = 0;
            
            nQueen(0); // 0번째 행부터 탐색 시작
            System.out.println("#" + tc + " " + cnt);
        }
        sc.close();
    } // main

    // 백트래킹을 활용한 N-Queen 풀이
    static void nQueen(int row) {
        if (row == N) { // 모든 행에 퀸을 배치했다면
            cnt++;
            return;
        }

        for (int col = 0; col < N; col++) { // 현재 행에서 가능한 모든 열 탐색
            if (isSafe(row, col)) { // 유효한 위치인지 확인
                board[row][col] = 1; // 퀸 배치
                nQueen(row + 1); // 다음 행으로 이동
                board[row][col] = 0; // 백트래킹
            }
        }
    }

    // 퀸을 배치할 수 있는지 확인하는 함수
    static boolean isSafe(int row, int col) {
        // 1. 같은 열(col)에 퀸이 있는지 확인
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // 2. 왼쪽 위 대각선 (\ 방향) 확인
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // 3. 오른쪽 위 대각선 (/ 방향) 확인
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }
}
