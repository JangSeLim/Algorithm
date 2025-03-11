import java.util.Scanner;

public class Solution {

    static int N, minDiff;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            arr = new int[N][N];
            minDiff = Integer.MAX_VALUE;

            // 점수 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 비트마스크를 사용하여 조합 탐색
            for (int mask = 0; mask < (1 << N); mask++) {  // 2^N개의 경우를 확인
                // 비트마스크의 1의 개수가 N/2와 같은 경우만 유효한 팀 분배
                if (Integer.bitCount(mask) == N / 2) {
                    int sumA = 0, sumB = 0;

                    // 각 팀의 점수 합 계산
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (((mask >> i) & 1) == 1 && ((mask >> j) & 1) == 1) {
                                sumA += arr[i][j];  // 팀 A
                            } else if (((mask >> i) & 1) == 0 && ((mask >> j) & 1) == 0) {
                                sumB += arr[i][j];  // 팀 B
                            }
                        }
                    }

                    // 최소 차이값 갱신
                    minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
                }
            }

            // 결과 출력
            System.out.println("#" + tc + " " + minDiff);
        }
    }
}
