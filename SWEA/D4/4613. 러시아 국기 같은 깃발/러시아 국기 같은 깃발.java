import java.util.Scanner;

class Solution {
    static int N, M;
    static char[][] colors;
    static int[][] colorCount;
    static int minCnt;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            colors = new char[N][M];
            colorCount = new int[N][3]; // W, B, R 각각 필요 변경 횟수 저장

            // 입력받으면서 각 행에서 색 변경 횟수 미리 계산
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < M; j++) {
                    colors[i][j] = str.charAt(j);
                    if (colors[i][j] != 'W') colorCount[i][0]++;
                    if (colors[i][j] != 'B') colorCount[i][1]++;
                    if (colors[i][j] != 'R') colorCount[i][2]++;
                }
            }

            minCnt = Integer.MAX_VALUE;
            divideAndCount();
            System.out.println("#" + test_case + " " + minCnt);
        }
    }

    // 색칠하는 최소 변경 횟수 계산
    static void divideAndCount() {
        // W(흰색) -> B(파란색) -> R(빨간색) 구간을 나누는 방식
        for (int whiteEnd = 1; whiteEnd < N - 1; whiteEnd++) { // 흰색 구간 끝
            for (int blueEnd = whiteEnd + 1; blueEnd < N; blueEnd++) { // 파란색 구간 끝
                int changes = 0;

                // O(1)로 구간별 변경 횟수 계산
                changes += getColorChanges(0, whiteEnd, 0); // 흰색 구간
                changes += getColorChanges(whiteEnd, blueEnd, 1); // 파란색 구간
                changes += getColorChanges(blueEnd, N, 2); // 빨간색 구간

                minCnt = Math.min(minCnt, changes);
            }
        }
    }

    // 특정 색으로 바꿔야 하는 칸의 개수를 O(1)로 계산
    static int getColorChanges(int start, int end, int color) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += colorCount[i][color];
        }
        return sum;
    }
}
