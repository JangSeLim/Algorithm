// 동적계획법
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int[] fee; // 요금제
    static int[] swim; // 월 별 이용 계획
    static int min; // 가장 적은 비용

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();

            // 입력 받기
            fee = new int[4];
            for (int i = 0; i < 4; i++) {
                fee[i] = sc.nextInt();
            }
            swim = new int[12];
            for (int i = 0; i < 12; i++) {
                swim[i] = sc.nextInt();
            }

            // 1년권 비용으로 초기화
            min = fee[3];

            // dp 배열 선언
            int[] dp = new int[12];

            for (int i = 0; i < 12; i++) {
                if (swim[i] == 0) {
                    dp[i] = (i > 0) ? dp[i - 1] : 0;  // 수영을 안하는 달은 이전 달과 같음
                    continue;
                }

                // 1일권: swim[i] * fee[0]
                int dayFee = swim[i] * fee[0];
                // 한달권: fee[1]
                int monthFee = fee[1];

                // 이번 달에 대한 최소 요금
                dp[i] = Math.min(dayFee, monthFee);

                // 이전 달과 비교하여 누적 요금 계산
                if (i > 0) {
                    dp[i] += dp[i - 1];
                }

                // 3개월권을 적용할 수 있는 경우 (i >= 2일 때만)
                if (i >= 2) {
                    dp[i] = Math.min(dp[i], (i >= 3 ? dp[i - 3] : 0) + fee[2]);
                }
                
            }
            // 최종적으로 1년권과 비교하여 최저 요금 구하기
            min = Math.min(min, dp[11]);

            sb.append("#").append(tc).append(" ").append(min);
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
