import java.util.Scanner;

class Solution {
    static int N, M;
    static char[][] colors;
    static int minCnt; // 최소 색칠 횟수

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // N: 행의 개수
            M = sc.nextInt(); // M: 열의 개수
            colors = new char[N][M];

            // 깃발 정보 입력
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < M; j++) {
                    colors[i][j] = str.charAt(j);
                }
            }

            minCnt = Integer.MAX_VALUE;
            divideAndCount(0, N);

            System.out.println("#" + test_case + " " + minCnt);
        }
    }

    // 세 구간을 나누는 함수
    static void divideAndCount(int start, int end) {
        // 첫 번째 구간의 끝을 설정
        for (int whiteEnd = start + 1; whiteEnd < end - 1; whiteEnd++) {
            // 두 번째 구간의 끝을 설정
            for (int blueEnd = whiteEnd + 1; blueEnd < end; blueEnd++) {
                // 색칠 횟수 계산
                int changes = 0;
                changes += countChanges(start, whiteEnd, 'W'); // 첫 번째 구간: 흰색
                changes += countChanges(whiteEnd, blueEnd, 'B'); // 두 번째 구간: 파란색
                changes += countChanges(blueEnd, end, 'R'); // 세 번째 구간: 빨간색

                // 최소 변경 횟수 갱신
                minCnt = Math.min(minCnt, changes);
            }
        }
    }

    // 구간에 대해 색을 맞추는 데 필요한 색칠 횟수 계산
    static int countChanges(int start, int end, char color) {
        int changes = 0;
        for (int i = start; i < end; i++) {
            for (int j = 0; j < M; j++) {
                if (colors[i][j] != color) {
                    changes++;
                }
            }
        }
        return changes;
    }
}

// 흰, 빨, 파 연속구간으로 나누기
// 각 나눈 구간에서 변경해야 할 칸의 개수 세기
// 최솟값 갱신