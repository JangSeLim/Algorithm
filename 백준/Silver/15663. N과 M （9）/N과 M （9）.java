import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr, nums;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);  // 배열을 정렬하여 중복된 수를 처리하기 쉽게 만듬

        nums = new int[M];
        visited = new boolean[N];  // 방문 여부를 체크하는 배열
        recur(0);  // 순열을 생성하는 재귀 함수 호출
        System.out.println(sb);
    }

    static void recur(int idx) {
        if (idx == M) {  // M개를 다 채우면 출력
            for (int n : nums) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            // 자기 자신을 다시 선택하는 것을 막기 위한 조건
            if (visited[i]) continue;  // 이미 선택된 값은 건너뜀

            // 중복을 피하기 위해, 이미 이전에 선택한 값은 다시 선택하지 않음
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;

            nums[idx] = arr[i];
            visited[i] = true;  // 해당 값 선택
            recur(idx + 1);
            visited[i] = false;  // 선택 해제
        }
    }
}
