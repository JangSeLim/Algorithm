import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr; // 내림차순 정렬을 위해 Integer 배열 사용
    static boolean[] visited; // 방문 체크
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N]; // 방문 여부 체크 배열

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 입력값을 내림차순으로 정렬
        Arrays.sort(arr);

        ArrayList<Integer> list = new ArrayList<>();
        recur(0, list);
        System.out.println(sb);
    }

    static void recur(int depth, ArrayList<Integer> list) {
        if (list.size() == M) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 중복 방지를 위해 방문 여부 체크
                visited[i] = true; // 방문 표시
                list.add(arr[i]);
                recur(depth + 1, list);
                list.remove(list.size() - 1);
                visited[i] = false; // 백트래킹 시 원상 복구
            }
        }
    }
}
