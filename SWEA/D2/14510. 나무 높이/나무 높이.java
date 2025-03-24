import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] tree = new int[N];

            // 입력 받으면서 가장 높은 나무 찾기
            int max = -1;

            for (int i = 0; i < N; i++) {
                tree[i] = sc.nextInt();
                max = Math.max(max, tree[i]);
            }

            int one = 0;
            int two = 0;

            for (int i = 0; i < N; i++) {
                int diff = max - tree[i];
                two += diff / 2; // 2칸짜리가 몇 개 들어갈 수 있는가
                one += diff % 2; // 1칸짜리가 몇 개 들어갈 수 있는가
            }

            if (two - one >= 2) {
                int diff = two - one;
                int move = (diff + 1) / 3;
                two -= move * 1;
                one += move * 2;
            }

            int answer = two * 2;
            if (one > two) {
                answer += (one - two - 1) * 2 + 1;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}