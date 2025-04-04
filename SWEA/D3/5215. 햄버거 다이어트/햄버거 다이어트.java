import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 재료의 개수
            int L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            int[] scores = new int[N]; // 맛 점수
            int[] cals = new int[N];   // 칼로리

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken()); // 맛 점수
                cals[i] = Integer.parseInt(st.nextToken());   // 칼로리
            } // 입력 완료

            int[][] dp = new int[N + 1][L + 1]; // DP

            // 0번째 행은 아무것도 사용하지 않은 경우 (초기화 불필요)
            for (int i = 1; i <= N; i++) {
                for (int l = 0; l <= L; l++) {
                    // 현재 재료를 선택하지 않는 경우 (이전 값 유지)
                    dp[i][l] = dp[i - 1][l];

                    // 현재 재료를 선택할 수 있는 경우 (칼로리 제한 확인)
                    if (cals[i - 1] <= l) { // i번째 재료는 배열 인덱스 (i-1)에 있음
                        dp[i][l] = Math.max(dp[i][l], dp[i - 1][l - cals[i - 1]] + scores[i - 1]);
                    }
                }
            }

            System.out.println("#" + tc + " " + dp[N][L]); // 결과 출력
        }
    }
}
