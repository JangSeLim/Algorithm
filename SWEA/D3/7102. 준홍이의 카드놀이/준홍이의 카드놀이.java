import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] freq = new int[N + M + 1];
            int maxCnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int sum = i + j;
                    freq[sum]++;
                    maxCnt = Math.max(maxCnt, freq[sum]);
                }
            }

            System.out.print("#" + test_case + " ");
            for (int sum = 2; sum <= N + M; sum++) {
                if (freq[sum] == maxCnt) {
                    System.out.print(sum + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
