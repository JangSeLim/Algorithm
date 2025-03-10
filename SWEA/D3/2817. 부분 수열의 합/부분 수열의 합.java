import java.util.Scanner;

public class Solution {
    static int N, K;
    static int[] arr;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt(); // 배열 크기
            K = sc.nextInt(); // 목표 합
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            count = 0;
            findSubsets(0, 0);

            System.out.println("#" + t + " " + count);
        }
        sc.close();
    }

    static void findSubsets(int idx, int sum) {
        if (idx == N) {
            return;
        }

        // 현재 요소 선택하는 경우
        if (sum + arr[idx] == K) {
            count++;
        }
        findSubsets(idx + 1, sum + arr[idx]); // 포함하는 경우
        findSubsets(idx + 1, sum); // 포함하지 않는 경우
    }

}